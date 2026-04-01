
package edp.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

                boolean found = false;
                for (int i = 0; i < cashierModel.getRowCount(); i++) {
                    String existingBarcode = cashierModel.getValueAt(i, 0).toString();
                    if (existingBarcode.equals(barcode)) {
                        // Update existing row
                        int existingQty = Integer.parseInt(cashierModel.getValueAt(i, 2).toString());
                        int newQty = existingQty + qty;
                        cashierModel.setValueAt(newQty, i, 2); // update quantity
                        cashierModel.setValueAt(price * newQty, i, 4); // update subtotal
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