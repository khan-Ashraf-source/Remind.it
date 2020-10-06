/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.LoginVerify;
import Utility.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ash
 */
public class LoginModel implements IModel{

    @Override
    public void responder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");
        LoginVerify lv=new LoginVerify();
        User user=lv.verifyLogin(email, pass);
        if(user!=null && user.getStatus()==1){
            HttpSession session=request.getSession();
            session.setAttribute("user", user);
            System.out.println("Login Successfull");
            try {
                response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=TodoList&type=model");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if(user !=null && user.getStatus()==0){
            request.setAttribute("message", "Verify your email");
            request.getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
            
        }
        else {
            request.setAttribute("message","Check your credentials");
            System.out.println("Check your credentials");
            request.getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
        }
        
    }
    
}
