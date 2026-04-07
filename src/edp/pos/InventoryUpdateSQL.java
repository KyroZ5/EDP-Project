package edp.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class InventoryUpdateSQL {

    public static boolean reduceStock(String barcode, int qty) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","")) {
            PreparedStatement check = con.prepareStatement("SELECT stock, itemName FROM inventory WHERE barcode=?");
            check.setString(1, barcode);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                int currentStock = rs.getInt("stock");
                String itemName = rs.getString("itemName");

                int newStock = currentStock - qty;
                if (newStock < 0) {
                    newStock = 0;
                }

                PreparedStatement pst = con.prepareStatement("UPDATE inventory SET stock=? WHERE barcode=?");
                pst.setInt(1, newStock);
                pst.setString(2, barcode);
                pst.executeUpdate();

                if (newStock == 0) {
                    JOptionPane.showMessageDialog(null,
                        "Item \"" + itemName + "\" is now OUT OF STOCK!",
                        "Stock Warning", JOptionPane.WARNING_MESSAGE);
                } else if (newStock < 10) {
                    JOptionPane.showMessageDialog(null,
                        "Item \"" + itemName + "\" stock is low (" + newStock + " left).",
                        "Stock Warning", JOptionPane.WARNING_MESSAGE);
                }

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Item not found in inventory!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
