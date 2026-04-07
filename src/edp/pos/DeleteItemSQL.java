package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;

public class DeleteItemSQL {
    public static boolean deleteItem(int barcode) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
             PreparedStatement pst = con.prepareStatement("delete from inventory where barcode=?")) {

            pst.setInt(1, barcode);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
