/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.Todo;
import Utility.TodoService;
import Utility.User;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ash
 */
public class AddTodo implements IModel {
    private TodoService todoService;
    
    public AddTodo(){
        todoService=new TodoService();
    }
    public void responder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String title=request.getParameter("todoName");
        String desc=request.getParameter("todoDesc");
        String status=request.getParameter("status");
        String date=request.getParameter("targetDate");
        System.out.println("Date: "+ date);
        LocalDate targetDate=LocalDate.parse(date);
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        int uid=user.getUid();
        Todo newTodo=new Todo(null,title,desc,status,targetDate,uid);
        todoService.insertTodo(newTodo);
        response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=TodoList&type=model");
    }
    
    
}
