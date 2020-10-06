/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.VerifyRegistration;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ash
 */
public class ValidateRegistration implements IModel{
    public void responder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String code=request.getParameter("code");
        VerifyRegistration vr=new VerifyRegistration();
        vr.verifyRegistration(code);
        response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=login&type=view");
    }
}
