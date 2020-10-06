<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body style="background-color: blue">
        <% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            if (session.getAttribute("user") != null) {%>
        <nav class="navbar navbar-expand-lg navbar-light mx-4">
            <a class="navbar-brand" style="color: white" href="#">Remind.it</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" style="color: white" href="?page=Logout&type=model">Logout</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="?page=newTodo&type=view">Add todo</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container" ><br><br>
            <h2 style="color: white">Todo list</h2><br>
            <table class="table" style="background-color: white">
                <thead>
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Description</th>
                        <th scope="col">Status</th>
                        <th scope="col">Date</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                <% 
                    if(request.getAttribute("todoList") != null){%>
                <c:forEach var="todo" items="${todoList}">
                    <tr>
                        <td><c:out value="${todo.todoName}" /></td>
                        <td><c:out value="${todo.todoDesc}" /></td>
                        <td><c:out value="${todo.todoStatus}" /></td>
                        <td><c:out value="${todo.targetDate}" /></td>

                        <td><a href="?page=EditTodo&type=model&id=<c:out value='${todo.todoId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; 
                            <a href="?page=DeleteTodo&type=model&id=<c:out value='${todo.todoId}' />">Delete</a>
                        </td>


                    </tr>
                </c:forEach>
                <% } %>
                </tbody>
            </table>
        </div>
        <%}else if(session.getAttribute("user")==null){        
                response.sendRedirect("login.jsp"); 
        }%>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>