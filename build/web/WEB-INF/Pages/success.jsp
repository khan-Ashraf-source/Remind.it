

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo List</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/successCss.css">
    </head>
    <body>
        
        <% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
           response.setHeader("Pragma","no-cache");
            if(session.getAttribute("user")!=null){%>
           
       
        <header>
            <div class="container head">
                <div class="logo">
                    <p></p>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="?page=Logout&type=model">Logout</a><br></li>
                        <li><a href="?page=addTodo&type=view">Add Todo</a><br></li>
                        
                        
                    </ul>
                </div>
            </div>
        
        
        <br>
        
        </header>
        
        <table class="content-table">
            <h1>Todo List</h1>  
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

        <td><a href="?page=EditTodo&type=model&id=<c:out value='${todo.todoId}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp; 
            <a href="?page=DeleteTodo&type=model&id=<c:out value='${todo.todoId}' />">Delete</a></td>

       
      </tr>
     </c:forEach>
    
    </tbody>
            
    </table>
            <%}else if(session.getAttribute("user")==null){        
                response.sendRedirect("loginPage.jsp"); 
            }%>    
        </header>
    </body>
</html>
