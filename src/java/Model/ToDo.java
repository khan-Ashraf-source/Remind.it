/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author ash
 */
public class ToDo {
    private Integer todoId;
    private String todoName;
    private String todoDesc;
    private boolean todoStatus;
    private LocalDate targetDate;
    private Integer uid;
    
    
    
    public ToDo(Integer todoId, String todoName, String todoDesc, boolean todoStatus,LocalDate targetDate,Integer uid){
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

    public boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        this.todoStatus = todoStatus;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    
    
    
}
