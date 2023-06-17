<%-- 
    Document   : shoppingList
    Created on : Jun 16, 2023, 8:25:34 AM
    Author     : danielchow
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello, ${username}
            <a href="ShoppingList?action=logout">Logout</a>
        </div>

        <form action="ShoppingList" method="post">
            <h1>List</h1>   
            <label>Add item: </label>
            <input type="test" name="item">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
            ${noitemMessage}
            <br>
        </form>

        <form action="ShoppingList" method="post">
            <ul>
                <c:forEach var="item" items="${itemList}">
                    <input type="radio" name="selectedItem" value="${item}">
                    <label>${item}</label>
                    <br>
                </c:forEach>
            </ul>

            <c:if test="${not empty itemList}">
                <input type="submit" value="Delete">
                <input type="hidden" name="action" value="delete">
            </c:if>

        </form>
    </body>
</html>
