<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/7/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<h2>Add Customer</h2>
<form method="post">
    <input type="text" name="name"  placeholder="Customer Name"/><br/>
    <input type="text" name="className"  placeholder="Class Name"/><br/>
    <input type="text" name="address" placeholder="Address"/><br/>
    <input type="text" name="dateOfBirth" placeholder="Date Of Birth"/><br/>
    <input type="submit">
</form>
</body>
</html>
