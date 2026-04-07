package edp.pos;

import java.sql.*;

public class AddAccounts {
    static boolean addAccounts(String name, String username, String password, String role) {
        if (usernameExists(username)) {
            System.out.println("Username already exists!");
            return false;
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
             PreparedStatement pst = conn.prepareStatement("INSERT INTO accounts (name, username, password, role) VALUES (?, ?, ?, ?)")) {

            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, role);
            
            pst.executeUpdate();
            System.out.println("Account added successfully!");
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    static boolean usernameExists(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = conn.prepareStatement("select count(*) from accounts where username = ?")) {

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error checking username: " + e.getMessage());
        }
        return false;
    }
}

    