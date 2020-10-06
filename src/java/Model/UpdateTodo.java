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
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ash
 */
public class UpdateTodo implements IModel{
    
    private TodoService todoService;
    
    public UpdateTodo(){
        todoService=new TodoService();
    }
    
 
    public void responder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int todoId=Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("todoName");
        String desc=request.getParameter("todoDesc");
        String status=request.getParameter("status");
        System.out.println("Status in updatetodo class of model:"+ status);
        String date=request.getParameter("targetDate");
        LocalDate targetDate=LocalDate.parse(date);
        User user=(User)request.getSession().getAttribute("user");
        int uid=user.getUid();
        Todo todo=new Todo(todoId,title,desc,status,targetDate,uid);
        todoService.updateTodo(todo);
        response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=TodoList&type=model");
    }
}
