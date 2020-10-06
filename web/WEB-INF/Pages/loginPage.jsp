<%-- 
    Document   : loginPage
    Created on : Jun 1, 2020, 2:36:21 PM
    Author     : ash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginCss.css">
    </head>
    <body>
        <header>
            <div class="container head">
                <div class="logo">
                    <p></p>
                </div>
                <div class="menu">
                    <ul>
                        <li><a href="?page=loginPage&type=view">Login</a></li>
                        <li><a href="?page=registerPage&type=view">Register</a></li>
                        
                        
                    </ul>
                </div>
            </div>

            <div class="box">
                <h1>Login</h1><br>
                <form action="/WorkD/Controller/?page=LoginModel&type=model" method="post">
                                
                                    
                                    <input type="text" name="email" placeholder="Email" >
                                
                                
                                    <br><br>
                                    <input type="text" name="pass" placeholder="Password" >
                                
                                
                                    <br><br>
                                    <input type="submit" name="submit" value="submit">
                                
                                    
                                    <a href="?page=registerPage&type=view">Register --></a>
                                
                            </form>
                <%  
                    if (request.getAttribute("message")!=null){%>
                    <h3>${message}</h3>
                <%}%>
            </div>
        </header>
    </body>
</html>
