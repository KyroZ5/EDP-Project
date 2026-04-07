package edp.pos;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class AccountsSearchSQL {

    public static void searchAccounts(DefaultTableModel model, String keyword) {
        model.setRowCount(0); 

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
             PreparedStatement pst = con.prepareStatement("SELECT * FROM accounts WHERE CONCAT_WS(' ', id, name, username, role) LIKE ?")) {

            pst.setString(1, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                String maskedPassword = "*".repeat(password.length());

                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("username"),
                    maskedPassword,
                    rs.getString("role")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
