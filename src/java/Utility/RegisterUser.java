/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ash
 */
public class RegisterUser {
    public boolean insertUser(User user){
        try{
            Connection conn=DAO.getConnection();
            
            PreparedStatement ps=conn.prepareStatement("insert into user (first_name,last_name,password,email,code,status) values(?,?,?,?,?,?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getCode());
            ps.setInt(6, user.getStatus());
            if(ps.executeUpdate()>0){
                System.out.println("Data inserted successfully");
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
