/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ash
 */
public class VerifyRegistration {
    public boolean verifyRegistration(String code){
        boolean result=false;
        try(Connection conn=DAO.getConnection()){
            PreparedStatement ps=conn.prepareStatement("select email from user where code=?;");
            ps.setString(1, code);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String email=rs.getString("email");
            System.out.println(email);
            PreparedStatement ps1=conn.prepareStatement("update user set status=? where email=?;");
            ps1.setInt(1, 1);
            ps1.setString(2, email);
            if(ps1.executeUpdate()>1){
                result=true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
