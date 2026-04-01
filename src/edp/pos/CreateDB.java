package edp.pos;

import java.sql.*;

public class CreateDB {
    CreateDB(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            System.out.println("Connected to sql ..."); 
            Statement stmt = (Statement)conn.createStatement();
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            //stmt.executeUpdate("create database pos");
            //System.out.println("database created..");
            System.out.println("Using Database pos");
            
            stmt.executeUpdate("use pos");
            //stmt.executeUpdate("create table accounts(name varchar(50), username varchar(50), password varchar(50))");
            //System.out.println("table accounts created..");
            System.out.println("Using Table accounts");
            
//            stmt.executeUpdate("drop table inventory");
//            System.out.println("Dropped Inventory...");
            
//            stmt.executeUpdate("create table inventory(barcode int, itemName varchar(50), stock int, price double)");
//            System.out.println("table inventory created..");
            System.out.println("Using Table Inventory");
            conn.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
    }
}
