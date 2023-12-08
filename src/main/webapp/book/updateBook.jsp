<%--
  Created by IntelliJ IDEA.
  User: vanson
  Date: 08/12/2023
  Time: 00:53
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
    <h2>Add book</h2>
    <form action="/book?action=updateBook&id=<c:out value="${book.getId()}"/>" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" value="${book.getName()}"   placeholder="Name" name="name">
        </div>
        <div class="form-group">
            <label>Avatar</label>
            <input type="text" class="form-control" value="${book.getAvatar()}"  placeholder="avatar" name="avatar">
        </div>
        <div class="form-group">
            <label>Describes</label>
            <input type="text" class="form-control" value="${book.getDescribes()}"  placeholder="describes" name="describes">
        </div>
        <div class="form-group">
            <label>Status</label>
            <input type="text" class="form-control" value="${book.getStatus()}"   placeholder="status" name="status">
        </div>
        <div class="form-group">
            <label>Category</label>
            <input type="text" class="form-control" value="${book.getCategory()}"  placeholder="category" name="category">
        </div>
        <div class="form-group">
            <label>Author</label>
            <input type="text" class="form-control" value="${book.getAuthor()}"   placeholder="author" name="author">
        </div>

        <button type="submit" class="btn btn-primary" >Submit</button>
        <a type="button" href="/book"  class="btn btn-primary">Back</a>
    </form>
</div>

</body>
</html>
