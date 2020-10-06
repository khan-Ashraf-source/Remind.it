/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ash
 */
public class Logout implements IModel {
    
    public void responder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session=request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=login&type=view");
    }
    
    
}
