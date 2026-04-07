package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;

public class UpdateAccountSQL {

    public static boolean updateAccount(int id, String name, String username, String password, String role) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = con.prepareStatement("update accounts set name=?, username=?, password=?, role=? where id=?")) {

            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, role);
            pst.setInt(5, id);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
