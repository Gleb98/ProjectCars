<%--
  Created by IntelliJ IDEA.
  User: glebk
  Date: 06.04.2019
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create car</title>
</head>
<body>
<h3>New product</h3>
<form method="post">
    <label>Brand</label><br>
    <input name="brand"/><br><br>
    <label>User ID</label><br>
    <input name="user_id" type="number" /><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
