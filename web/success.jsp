<%-- 
    Document   : success
    Created on : Feb 26, 2020, 2:01:09 AM
    Author     : ash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% if(session.getAttribute("user")!=null){%>
           
        <h1>login successful!</h1>
        
        <a href="<%=request.getContextPath()%>/logout">Logout</a><br>
        <br>
        
        <a href="<%=request.getContextPath()%>/addTodo.jsp">Add Todo</a><br>
        
        <table class="table table-bordered">
        <thead>
        <tr>
            <th>Title</th>
            <th>Desc</th>
            <th>Target Date</th>
            <th>Todo Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
     <!--   for (Todo todo: todos) {  -->
        <c:forEach var="todo" items="${todoList}">

        <tr>
        <td><c:out value="${todo.todoName}" /></td>
        <td><c:out value="${todo.todoDesc}" /></td>
        <td><c:out value="${todo.targetDate}" /></td>
        <td><c:out value="${todo.todoStatus}" /></td>

        <td><a href="<%=request.getContextPath()%>/edit?id=<c:out value='${todo.todoId}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp; <a
            href="<%=request.getContextPath()%>/delete?id=<c:out value='${todo.todoId}' />">Delete</a></td>

       <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

    </table>
            <%}else if(session.getAttribute("user")==null){        
                response.sendRedirect("login.jsp"); 
            }%>    
        
    </body>
</html>
