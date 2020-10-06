/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ash
 */

public class DAO {
    public static Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytodo?useSSL=false","root","admin");
            
        }catch(SQLException e){
           e.printStackTrace();
        }
        return conn;
    }
    
}

