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
  <link rel="stylesheet" href="/CSS/bookList.css">

</head>
<body>

  <div class="container">
    <h2 class="title">Danh Sách Thư Viện</h2>
    <div class="box-nav">

      <ul class="nav nav-pills">
        <li class="nav-item">
          <a class="nav-link active"  href="/book?action=add">Add Book</a>
        </li>
      </ul>
  </div>
    <form action="/book" method="get">
      <div class="input-group">
        <input type="text" name="keyword" value="<c:out value="${keyword}"/>" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
        <button type="submit" class="btn btn-outline-primary" data-mdb-ripple-init>Search</button>
      </div>
    </form>

</div>


<div class="container">
  <table class="table table-dark table-striped">
    <thead>
    <tr>
      <th>Id</th>
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
        <td class="tbl-describes">${item.getDescribes()}</td>
        <td>${item.getStatus()}</td>
        <td>${item.getCategory()}</td>
        <td>${item.getAuthor()}</td>
        <td><button type="button"  class="btn btn-danger"><a class="btn-b" href="/book?action=delete&id=<c:out value="${item.getId()}"/>">Delete</a></button></td>
        <td><button type="button" class="btn btn-success" ><a class="btn-b"  href="/book?action=update&id=<c:out value="${item.getId()}"/>">Update</a></button></td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
</div>
</body>
</html>