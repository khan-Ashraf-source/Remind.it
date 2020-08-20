/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ash
 */
public interface ITodoService {
    void insertTodo(ToDo todo);
    ToDo selectTodo(int todoId);
    List<ToDo> getTodoList(int uid);
    boolean deleteTodo(int todoId);
    boolean updateTodo(ToDo todo);
}
