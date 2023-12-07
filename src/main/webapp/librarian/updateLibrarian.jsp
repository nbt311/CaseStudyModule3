<%--
  Created by IntelliJ IDEA.
  User: vanson
  Date: 07/12/2023
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <h2>Update book</h2>
    <form action="/librarian?action=update&id=${book.getId()}" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" value="${book.getName()}" class="form-control"   placeholder="Name" name="name">
        </div>
        <div class="form-group">
            <label>Avatar</label>
            <input type="text" value="${book.getAvatar()}" class="form-control"  placeholder="urlImg" name="avatar">
        </div>
        <div class="form-group">
            <label>Describes</label>
            <input type="text" value="${book.getDescribes()}" class="form-control"  placeholder="describes" name="describes">
        </div>
        <div class="form-group">
            <label>Status</label>
            <input type="text" value="${book.getStatus()}" class="form-control"  placeholder="status" name="status">
        </div>
        <div class="form-group">
            <label>Category</label>
            <input type="text" value="${book.getCategory()}" class="form-control"  placeholder="category" name="category">
        </div>
        <div class="form-group">
            <label>Author</label>
            <input type="text" value="${book.getAuthor()}" class="form-control"  placeholder="author" name="author">
        </div>

        <button type="submit" class="btn btn-primary" >ADD</button>
        <a type="button" href="/librarian"  class="btn btn-primary">Back</a>
    </form>
</div>

</body>
</html>
