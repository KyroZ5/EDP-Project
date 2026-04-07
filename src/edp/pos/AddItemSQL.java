
package edp.pos;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class AddItemSQL {
    static void addItem(String barcode, String itemName, int stock, double price){
    try
     {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "");
	System.out.println("Connected to pos...");
        PreparedStatement pst= (PreparedStatement) conn.prepareStatement("insert into inventory (barcode,itemName,stock,price) values(?,?,?,?)");
         
        
        pst.setString(1, barcode);
        pst.setString(2, itemName);
	pst.setInt(3, stock);
        pst.setDouble(4, price);
        
        pst.executeUpdate();
	System.out.println("Item Added Success!");
     }
     catch(Exception e)
     {  
       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     }
    }
}
