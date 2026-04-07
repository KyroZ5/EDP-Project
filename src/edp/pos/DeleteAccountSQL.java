package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;

public class DeleteAccountSQL {

    public static boolean deleteAccount(int id) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
             PreparedStatement pst = con.prepareStatement("delete from accounts where id=?")) {

            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
