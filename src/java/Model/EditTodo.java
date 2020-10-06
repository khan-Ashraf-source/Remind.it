/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.Todo;
import Utility.TodoService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ash
 */
public class EditTodo implements IModel{
    private TodoService todoService;
    
    public EditTodo(){
        todoService=new TodoService();
    }
    
    public void responder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int todoId=Integer.parseInt(request.getParameter("id"));
        Todo existingTodo=todoService.selectTodo(todoId);
        request.setAttribute("todo", existingTodo);
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Pages/newTodo.jsp");
        rd.forward(request, response);
    }
}
