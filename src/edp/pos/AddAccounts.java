package edp.pos;

import java.sql.*;

public class AddAccounts {
    static void addAccounts(String name, String username, String password){
    try
        {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
        System.out.println("Connected To SQL");//just for checking
        PreparedStatement pst= conn.prepareStatement("insert into students values(?,?,?)");

        pst.setString(1, name);
        pst.setString(2, username);
        pst.setString(3, password);
        
        pst.executeUpdate();
        System.out.println("Account added successfully!");
        conn.close();
    }
        catch(Exception e){
          System.out.println("Error: "+e.getMessage());
        }
    }
}
