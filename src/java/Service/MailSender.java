/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ash
 */
public class MailSender {
    public boolean sendMail(String email,String ucode){
        String from="cryptonomous1997@gmail.com";
        final String username="cryptonomous1997@gmail.com";
        final String password="Cryptoman@1997";
        String host="smtp.gmail.com";
        Properties props=new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        Session sess= Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });
        try{
            Message msg=new MimeMessage(sess);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
            msg.setSubject("Welcome Email");
            msg.setText("Welcome to our site");
            msg.setText("http://localhost:8080/MyToDo/validateRegistration?code="+ucode);
            Transport.send(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
 

