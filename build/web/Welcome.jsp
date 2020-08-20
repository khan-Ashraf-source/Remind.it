<%-- 
    Document   : Welcome
    Created on : Feb 26, 2020, 1:20:55 AM
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
        <a href="<%=request.getContextPath()%>/login.jsp">Login</a><br>
        <a href="<%=request.getContextPath()%>/registration.jsp">Register</a><br>
    </body>
</html>
