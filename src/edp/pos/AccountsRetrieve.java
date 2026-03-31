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
        String Name = rs.getString("Name");
        String Username = rs.getString("Username");
        String Password = rs.getString("Password");
         
        userModel.addRow(new Object[]{Name,Username,Password});
        
        }
    }
        catch(Exception e){ 
            System.out.println(e.getMessage());
            Accounts a = new Accounts();
            JOptionPane.showMessageDialog(a, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
