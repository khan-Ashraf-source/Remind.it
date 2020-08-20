<%-- 
    Document   : login
    Created on : Feb 26, 2020, 1:21:11 AM
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
        <%  
            if(request.getAttribute("message")!=null){%>
            <h3>${message}</h3><br>
        <%}%>
        
        
        <form action="login" method="post">
            Email: <input type="text" name="email"><br>
            Password: <input type="password" name="pass"><br>
            <input type="submit" value="Login"><br>
            
            <a href="<%=request.getContextPath()%>/registration.jsp">Register here</a><br>
        </form>
    </body>
</html>
