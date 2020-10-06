/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ash
 */
public class TodoService {
    public Todo selectTodo(int todoId){
        Todo todo=null;
        try(Connection conn=DAO.getConnection()){
            PreparedStatement ps=conn.prepareStatement("select * from todos where todo_id=?;");
            ps.setInt(1, todoId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int tId=rs.getInt("todo_id");
                String name=rs.getString("todo_name");
                String desc=rs.getString("todo_desc");
                String status=rs.getString("todo_status");
                LocalDate date=rs.getDate("target_date").toLocalDate();
                int uid=rs.getInt("uid");
                todo=new Todo(tId,name,desc,status,date,uid);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return todo;
    }
    
    public List<Todo> getTodoList(int uid){
        List<Todo> myTodo=null;
        try(Connection conn=DAO.getConnection()){
            PreparedStatement ps=conn.prepareStatement("select * from todos where uid=?;");
            ps.setInt(1, uid);
            ResultSet rs=ps.executeQuery();
            myTodo=new ArrayList<Todo>();
            while(rs.next()){
                int todoId=rs.getInt("todo_id");
                String todoName=rs.getString("todo_name");
                String todoDesc=rs.getString("todo_desc");
                String status=rs.getString("todo_status");
                LocalDate date=rs.getDate("target_date").toLocalDate();
                int id=rs.getInt("uid");
                Todo todo=new Todo(todoId,todoName,todoDesc,status,date,id);
                myTodo.add(todo);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }if(myTodo==null){
            System.out.println("todoList empty");
        }
        return myTodo;
    } 
    
    
    public boolean deleteTodo(int todoId){
        boolean result=false;
        try(Connection conn=DAO.getConnection()){
            PreparedStatement ps=conn.prepareStatement("delete from todos where todo_id=?;");
            ps.setInt(1, todoId);
            result=ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    public boolean updateTodo(Todo todo){
        System.out.println("Update todo method called in todoService");
        boolean result=false;
        try(Connection conn=DAO.getConnection()){
            PreparedStatement ps=conn.prepareStatement("update todos set todo_name=?, todo_desc=?, todo_status=?, target_date=? where todo_id=?;");
            ps.setString(1,todo.getTodoName());
            ps.setString(2, todo.getTodoDesc());
            System.out.println("status: "+ todo.getTodoStatus());
            ps.setString(3, todo.getTodoStatus());
            ps.setDate(4, Date.valueOf(todo.getTargetDate()));
            ps.setInt(5, todo.getTodoId());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    
    public void insertTodo(Todo todo) {
        try(Connection conn=DAO.getConnection()){
            PreparedStatement ps=conn.prepareStatement("insert into todos (todo_name,todo_desc,todo_status,target_date,uid) values(?,?,?,?,?);");
            //ps.setInt(1,todo.getTodoId());
            ps.setString(1, todo.getTodoName());
            ps.setString(2, todo.getTodoDesc());
            ps.setString(3, todo.getTodoStatus());
            ps.setDate(4, Date.valueOf(todo.getTargetDate()));
            ps.setInt(5, todo.getUid());
            if(ps.executeUpdate()>0){
                System.out.println("Data entered");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
