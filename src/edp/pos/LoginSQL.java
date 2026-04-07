package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;

public class LoginSQL {
    public static Users authenticate(String username, String password) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "")) {
            PreparedStatement pst = con.prepareStatement("select * from accounts where username=? and  password=?");
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Users(
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("role")
            );

            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
