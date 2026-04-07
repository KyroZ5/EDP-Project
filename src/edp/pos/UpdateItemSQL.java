package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;

public class UpdateItemSQL {
    public static boolean updateItem(String barcode, String itemName, int stock, double price) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = con.prepareStatement("update inventory set itemName=?, stock=?, price=? where barcode=?")) {

            pst.setString(1, itemName);
            pst.setInt(2, stock);
            pst.setDouble(3, price);
            pst.setString(4, barcode);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}