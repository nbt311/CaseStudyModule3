<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/admin?action=add">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>phone</th>
            <th>avatar</th>
            <th>username</th>
            <th>password</th>
            <th>role</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getPhone()}</td>
                <td><img src=`${user.getAvatar()}`></td>
                <td>${user.getUsername()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getRole()}</td>
                <td>
                    <a href="/admin?action=update&id=${user.getId()}">Update</a>
                    <a href="/admin?action=delete&id=${user.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>