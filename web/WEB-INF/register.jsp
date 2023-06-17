<%-- 
    Document   : register
    Created on : Jun 16, 2023, 8:26:00 AM
    Author     : danielchow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ShoppingList" method="post">
        <h1>Shopping List</h1>
        <label>Username: </label>
        <input type="test" name="username">
        <input type="submit" value="Register">
        <input type="hidden" name="action" value="register">
        <br>
        ${errorMessage}
        <br>
        ${LogoutMessage}
        </form>
    </body>
</html>
