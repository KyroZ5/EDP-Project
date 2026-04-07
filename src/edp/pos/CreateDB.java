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
            
//            stmt.executeUpdate("create database pos");
//            System.out.println("database created..");
            System.out.println("Using Database pos");
            
            stmt.executeUpdate("use pos");
            
//            stmt.executeUpdate("drop table accounts");
//            System.out.println("Dropped table accounts!");
            
//            stmt.executeUpdate("create table accounts(id int auto_increment primary key, name varchar(50), username varchar(50), password varchar(50))");
//            System.out.println("table accounts created..");
            System.out.println("Using Table accounts");
            
//            stmt.executeUpdate("ALTER TABLE accounts ADD COLUMN role VARCHAR(20) DEFAULT 'CASHIER';");
//            stmt.executeUpdate("INSERT INTO accounts (name, username, password, role) values ('System Admin', 'admin', 'admin', 'ADMIN');");
//            System.out.println("Inserted Done...");

//            stmt.executeUpdate("UPDATE accounts SET role='ADMIN' WHERE username='admin';");
//            stmt.executeUpdate("UPDATE accounts SET role='CASHIER' WHERE role IS NULL;");
//            System.out.println("Update done...");
            
//            stmt.executeUpdate("drop table inventory");
//            System.out.println("Dropped Inventory...");
            
//            stmt.executeUpdate("create table inventory(barcode int , itemName varchar(50), stock int, price double)");
//            System.out.println("table inventory created..");
            System.out.println("Using Table Inventory");
            
//            stmt.executeUpdate("Drop table transactions");
//            System.out.println("Drop Done...");
            
//            stmt.executeUpdate("create table transactions(transaction_no INT auto_increment PRIMARY KEY, date_time DATETIME, amount DOUBLE, change_amount DOUBLE, staff VARCHAR(100))");
//            System.out.println("Table transactions created...");
            System.out.println("Using Table transactions");
            
            conn.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
    }
}
