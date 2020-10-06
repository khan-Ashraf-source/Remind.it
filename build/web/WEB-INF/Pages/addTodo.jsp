<%-- 
    Document   : addTodo
    Created on : May 19, 2020, 8:55:29 PM
    Author     : ash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Todo</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addTodoCss.css">
    </head>
    <body>
       
        <% if(session.getAttribute("user")==null){
           response.sendRedirect("login.jsp"); 
        }%>
        
        
        <header>
            <div class="container head">
                <div class="logo">
                    <p></p>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="?page=Logout&type=model">Logout</a></li>
                        
                        
                        
                    </ul>
                </div>
            </div>

            
            <div class="box">
        
            <h1>Create todo</h1><br>
            <% if(request.getAttribute("todo") != null){%>
                <form action="/WorkD/Controller/?page=UpdateTodo&type=model" method="post">
            <%}else if(request.getAttribute("todo") ==null){%>
                <form action="/WorkD/Controller/?page=AddTodo&type=model" method="post">
            <%}%>
        
        <% if(request.getAttribute("todo") !=null){%>
            <input type="hidden" name="id" value="${todo.todoId}" />
        <%}
        %>
        
        
        
        
        
        <label>Todo Title: <input type="text" name="todoName" placeholder="${todo.todoName}"></label><br>
        <label>Todo description: <input type="text" name="todoDesc" placeholder="${todo.todoDesc}"></label><br>
                <label for="status"> Todo Status: 
                <select  name="status">
                    
                    <option value="false">In-progress</option>
                    <option value="true">Completed</option>
                </select> </label><br>
                <label>Target Date: <input type="date" name="targetDate" ></label><br>
                <label><input type="submit" value="Submit"></label><br>
            </form>
        </div>
        </header>
    </body>
    
</html>
