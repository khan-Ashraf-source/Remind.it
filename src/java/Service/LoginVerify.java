/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAOLayer.DAO;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ash
 */
public class LoginVerify {
    public User verify(String email,String pass){
        User user=null;
        try{
            Connection conn=DAO.getConnection();
            PreparedStatement ps=conn.prepareStatement("select * from user where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                user=new User();
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setUid(rs.getInt("uid"));
                user.setCode(rs.getString("code"));
                user.setStatus(rs.getInt("status"));
                System.out.println("Login successful");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
