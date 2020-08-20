<%-- 
    Document   : addTodo
    Created on : Feb 26, 2020, 4:50:52 PM
    Author     : ash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(session.getAttribute("user")==null){
           response.sendRedirect("login.jsp"); 
        }%>
        <h1>Create todo</h1><br>
        <% if(request.getAttribute("todo") != null){%>
            <form action="<%=request.getContextPath()%>/update" method="post">
        <%}else if(request.getAttribute("todo") ==null){%>
            <form action="<%=request.getContextPath()%>/insert" method="post">
        <%}
        %>
        
        <% if(request.getAttribute("todo") !=null){%>
            <input type="hidden" name="id" value="${todo.todoId}" />
        <%}
        %>
                Todo Title: <input type="text" name="todoName"><br>
                Todo description: <input type="text" name="todoDesc"><br>
                <label for="status"> Todo Status: </label><br>
                <select  name="status">
                    <option value="false">In-progress</option>
                    <option value="true">Completed</option>
                </select>
                Target Date: <input type="date" name="targetDate"><br>
                <input type="submit" value="Submit"><br>
            </form>
    </body>
</html>
