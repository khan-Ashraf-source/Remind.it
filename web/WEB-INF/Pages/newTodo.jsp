<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Remind.it</title>
    </head>
    <body style="background-color: blue">
        <nav class="navbar navbar-expand-lg navbar-light mx-4">
            <a class="navbar-brand" style="color: white" href="?page=welcome&type=view">Remind.it</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item ">
                        <a class="nav-link" style="color: white" href="?page=Logout&type=model">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container" style="width: 400px; margin-top: 40px; color: white">
            <h2>Add Todo</h2><br>
            <% if (request.getAttribute("todo") != null) {%>
            <form action="/WorkD/Controller/?page=UpdateTodo&type=model" method="post">
                <input type="hidden" name="id" value="${todo.todoId}" />
                <%} else if (request.getAttribute("todo") == null) {%>
                <form action="/WorkD/Controller/?page=AddTodo&type=model" method="post">
                    <%}%>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Todo Title</label>
                        <input type="text" class="form-control" name="todoName" required placeholder="${todo.todoName}" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Todo Description</label>
                        <input type="text" class="form-control" name="todoDesc" required placeholder="${todo.todoDesc}" id="exampleInputPassword1">
                    </div>
                    <div class="form-group">
                        <label>Status</label><br>
                        <select name="status">  
                            <option value="In-progress">In-progress</option>
                            <option value="Complete">Completed</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Date</label>
                        <input type="date" class="form-control" required name="targetDate" id="exampleInputPassword1">
                    </div>

                    <button type="submit" class="btn btn-primary" style="color: white">Submit</button>
                </form>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>