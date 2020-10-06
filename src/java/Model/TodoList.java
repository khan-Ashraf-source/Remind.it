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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ash
 */
public class TodoList implements IModel{
    private TodoService todoService;
    
    public TodoList(){
        todoService=new TodoService();
    }
    
    
    public void responder(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        System.out.println("This is todolist class");
        List<Todo> todoList=new ArrayList<Todo>();
        HttpSession session=request.getSession(false);
        User user=(User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=login&type=view");
        }else{
            todoList= todoService.getTodoList(user.getUid());
            if(todoList!=null){
                System.out.println("todolist is not null");
            }
            System.out.println("Todo list: "+todoList);
            request.setAttribute("todoList", todoList);
            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/afterLogin.jsp");
            rd.forward(request, response);
        }
        
    }
}
