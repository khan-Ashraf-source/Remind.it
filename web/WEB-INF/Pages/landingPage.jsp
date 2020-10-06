<%-- 
    Document   : landingpage
    Created on : May 23, 2020, 7:53:34 AM
    Author     : ash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remind.it</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/landingCss.css">
        
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

            <div class="title-head">
                <h1>Welcome user.</h1>
                <a href="?page=loginPage&type=view">Learn more --></a>
            </div>
        </header>
    </body>
</html>
