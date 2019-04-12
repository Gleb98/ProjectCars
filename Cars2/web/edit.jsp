<%--
  Created by IntelliJ IDEA.
  User: glebk
  Date: 06.04.2019
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit car</title>
</head>
<body>
<h3>Edit car</h3>
<form method="post">
    <input type="hidden" value="${car.id}" name="id" />
    <label>Brand</label><br>
    <input name="brand" value="${car.brand}" /><br><br>
    <label>User ID</label><br>
    <input name="user_id" value="${car.user_id}" type="number"/><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
