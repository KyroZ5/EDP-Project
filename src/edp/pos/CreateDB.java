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
            System.out.println("database created..");
            
            stmt.executeUpdate("use pos");
            //stmt.executeUpdate("create table accounts(name varchar(50), username varchar(50), password varchar(50))");
            System.out.println("table created..");
            conn.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
    }
}
