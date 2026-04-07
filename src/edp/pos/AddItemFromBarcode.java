package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddItemFromBarcode {
    private DefaultTableModel cashierModel;

    public AddItemFromBarcode(DefaultTableModel cashierModel) {
        this.cashierModel = cashierModel;
    }

    public void addItem(String barcode, int qty) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","")) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM inventory WHERE barcode=?");
            pst.setString(1, barcode);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String itemName = rs.getString("itemName");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock"); 

                if (stock == 0) {
                    JOptionPane.showMessageDialog(null,
                        "Item \"" + itemName + "\" is OUT OF STOCK!",
                        "Stock Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (qty > stock) {
                    JOptionPane.showMessageDialog(null,
                        "Not enough stock for \"" + itemName + "\". Available: " + stock,
                        "Stock Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (stock <= 10) {
                    JOptionPane.showMessageDialog(null,
                        "Item \"" + itemName + "\" stock is low (" + stock + " left).",
                        "Stock Warning", JOptionPane.WARNING_MESSAGE);
                }

                boolean found = false;
                for (int i = 0; i < cashierModel.getRowCount(); i++) {
                    String existingBarcode = cashierModel.getValueAt(i, 0).toString();
                    if (existingBarcode.equals(barcode)) {
                        int existingQty = Integer.parseInt(cashierModel.getValueAt(i, 2).toString());
                        int newQty = existingQty + qty;

                        if (newQty > stock) {
                            JOptionPane.showMessageDialog(null,
                                "Cannot add more \"" + itemName + "\". Only " + stock + " left.",
                                "Stock Warning", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        cashierModel.setValueAt(newQty, i, 2);
                        cashierModel.setValueAt(price * newQty, i, 4); 
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    double subtotal = price * qty;
                    cashierModel.addRow(new Object[]{barcode, itemName, qty, price, subtotal});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Item not found!");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
