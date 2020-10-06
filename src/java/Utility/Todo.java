/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.time.LocalDate;

/**
 *
 * @author ash
 */
public class Todo {
    private Integer todoId;
    private String todoName;
    private String todoDesc;
    private String todoStatus;
    private LocalDate targetDate;
    private Integer uid;
    
    
    
    public Todo(Integer todoId, String todoName, String todoDesc, String todoStatus,LocalDate targetDate,Integer uid){
        this.todoId=todoId;
        this.todoName=todoName;
        this.todoDesc=todoDesc;
        this.todoStatus=todoStatus;
        this.targetDate=targetDate;
        this.uid=uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

  
    
    
    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoDesc() {
        return todoDesc;
    }

    public void setTodoDesc(String todoDesc) {
        this.todoDesc = todoDesc;
    }

    public String getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(String todoStatus) {
        this.todoStatus = todoStatus;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    
}
