package edp.pos;

import java.sql.*;

public class AddAccounts {
    static void addAccounts(String name, String username, String password){
    try
        {
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
        System.out.println("connected to sql");//just for checking
         Statement stmt=(Statement)conn.createStatement();
         PreparedStatement pst= conn.prepareStatement("insert into students values(?,?,?)");
         ResultSet rs=null;
         
        stmt.executeUpdate("use pos");
        // stmt.executeUpdate("insert into students values("+id+", 'Klinth', 25);");

        pst.setString(1, name);
        pst.setString(2, username);
        pst.setString(3, password);
        
        
        pst.executeUpdate();
     }
     catch(Exception e)
     {
        System.out.println("Error: "+e.getMessage());

     }
    }
}
