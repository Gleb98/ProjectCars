<%--
  Created by IntelliJ IDEA.
  User: glebk
  Date: 03.04.2019
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cars</title>
</head>
<body>
<h2>Cars List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr>
        <th>Brand</th>
        <th>User ID</th>
        <th></th>
    </tr>
    <jsp:useBean id="carsL" scope="request" type="java.util.List"/>
    <c:forEach var="car" items="${carsL}">
        <tr>
            <td>${car.brand}</td>
            <td>${car.user_id}</td>
            <td>
                <a href='<c:url value="/edit?id=${car.id}" />'>Edit</a>
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${car.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>