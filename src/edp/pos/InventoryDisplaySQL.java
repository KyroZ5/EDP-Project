package edp.pos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InventoryDisplaySQL {
    InventoryDisplaySQL(DefaultTableModel inventoryModel){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM inventory");
            ResultSet rs = pst.executeQuery();

            inventoryModel.setRowCount(0);

            while(rs.next()){
                int barcode = rs.getInt("barcode");
                String itemName = rs.getString("itemName");
                int stock = rs.getInt("stock");
                Double price = rs.getDouble("price");

            inventoryModel.addRow(new Object[]{barcode, itemName, stock, price,});
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
