/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.MailSender;
import Utility.RegisterUser;
import Utility.User;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ash
 */
public class RegistrationModel implements IModel{
    public void responder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String pass=request.getParameter("pass");
        String email=request.getParameter("email");
        String code=UUID.randomUUID().toString();
        User user=new User(fname,lname,pass,email,code,0);
        RegisterUser ru=new RegisterUser();
        boolean result=ru.insertUser(user);
        if(result){
            MailSender mail=new MailSender();
            mail.sendMail(request.getParameter("email"),code);
            response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=login&type=view");
        }else{
            request.setAttribute("message", "Email already exists");
            request.getRequestDispatcher("/WEB-INF/Pages/login.jsp").forward(request, response);
        }
    }
    
}
