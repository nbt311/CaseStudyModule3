<%--
  Created by IntelliJ IDEA.
  User: vanson
  Date: 08/12/2023
  Time: 00:26
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
    <form action="/book?action=addBook" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control"   placeholder="Name" name="name">
        </div>
        <div class="form-group">
            <label>Avatar</label>
            <input type="number" class="form-control"  placeholder="avatar" name="avatar">
        </div>
        <div class="form-group">
            <label>Describes</label>
            <input type="number" class="form-control"  placeholder="describes" name="describes">
        </div>
        <div class="form-group">
            <label>Status</label>
            <input type="text" class="form-control"  placeholder="status" name="status">
        </div>
        <div class="form-group">
            <label>Category</label>
            <input type="text" class="form-control"  placeholder="category" name="category">
        </div>
        <div class="form-group">
            <label>Author</label>
            <input type="text" class="form-control"  placeholder="author" name="author">
        </div>

        <button type="submit" class="btn btn-primary" >Submit</button>
        <a type="button" href="/book"  class="btn btn-primary">Back</a>
    </form>
</div>

</body>
</html>
