package edp.pos;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AccountsRetrieve {
    AccountsRetrieve(DefaultTableModel userModel){
     try
     {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
        PreparedStatement pst= con.prepareStatement("select*from accounts");
        ResultSet rs=pst.executeQuery();  
    
        userModel.setRowCount(0);
         
        while(rs.next()){
        int id = rs.getInt("id"); 
        String name = rs.getString("name");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String maskedPassword = "*".repeat(password.length());
        String role = rs.getString("role");
        
        userModel.addRow(new Object[]{id, name, username, maskedPassword, role});
        }
    }
        catch(Exception e){ 
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
