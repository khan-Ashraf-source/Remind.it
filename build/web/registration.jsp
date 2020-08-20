<%-- 
    Document   : registration
    Created on : Feb 26, 2020, 1:21:27 AM
    Author     : ash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <form action="registration" method="post">
            Email: <input type="email" name="email"><br>
            First Name: <input type="text" name="fname"><br>
            Last Name: <input type="text" name="lname"><br>
            Password: <input type="password" name="pass"><br>
            <input type="submit" value="Register"><br>
        </form>
    </body>
</html>
