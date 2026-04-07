package edp.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class InventorySearchSQL {

    public static void searchInventory(DefaultTableModel model, String keyword) {
        model.setRowCount(0);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM inventory WHERE CONCAT_WS(' ', barcode, itemName, stock, price) LIKE ?")) {

            pst.setString(1, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("barcode"),
                    rs.getString("itemName"),
                    rs.getInt("stock"),
                    rs.getDouble("price")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
