<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/5/2023
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/CSS/librarianHome.css">
</head>
<body>
<div class="container">
    <h2>Danh sách thư viện</h2>
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link active"  href="/products?action=create">Add</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
        </li>
    </ul>
</div>

<div class="container">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Avatar</th>
            <th>Describes</th>
            <th>Status</th>
            <th>Category</th>
            <th>Author</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${books}" >

            <tr>
                <td>${item.getId()}</td>
                <td>${item.getName()}</td>
                <td><img id="img-book" src="${item.getAvatar()}" alt=""></td>
                <td>${item.getDescribes()}</td>
                <td>${item.getStatus()}</td>
                <td>${item.getCategory()}</td>
                <td>${item.getAuthor()}</td>


            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
