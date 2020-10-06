/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utility.TodoService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ash
 */
public class DeleteTodo implements IModel{
    private TodoService todoService;

    public DeleteTodo(){
        todoService=new TodoService();
    }

    public void responder(HttpServletRequest request,HttpServletResponse response) throws IOException, IOException{
        int id=Integer.parseInt(request.getParameter("id"));
        todoService.deleteTodo(id);
        response.sendRedirect("http://localhost:8080/WorkD/Controller/?page=TodoList&type=model");
    }

}
