<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/7/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="/CSS/userList.css">
  <link rel="stylesheet" href="/CSS/adminHome.css">
  <title>Customer Management Application</title>
</head>
<body>
<section id="sidebar">
  <a href="/admin" class="brand">
    <i class='bx bxs-smile'></i>
    <span class="text">LibrarianHome</span>
  </a>
  <ul class="side-menu top">
    <li class="active">
      <a href="/admin">
        <i class='bx bxs-dashboard' ></i>
        <span class="text">Dashboard</span>
      </a>
    </li>
    <li>
      <a href="/book">
        <i class='bx bxs-book' ></i>
        <span class="text">Book List</span>
      </a>
    </li>
    <li>
      <a href="/admin?action=list">
        <i class='bx bxs-group' ></i>
        <span class="text">User List</span>
      </a>
    </li>
  </ul>
  <ul class="side-menu">
    <li>
      <a href="/login" class="logout">
        <i class='bx bxs-log-out-circle'></i>
        <span class="text">Logout</span>
      </a>
    </li>
  </ul>
</section>

<section id="content">
  <!-- NAVBAR -->
  <nav>
    <form action="#">
      <div class="form-input">
        <input type="search" placeholder="Search...">
        <button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
      </div>
    </form>
    <a href="#" class="profile">
      <img src="Image/admin-avatar.jpg"/>
    </a>
    <span class="user-name">Ten nguoi dung</span>
  </nav>
  <!-- NAVBAR -->
<main>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
  <div class="container mt-3 mb-4">
    <div class="col-lg-9 mt-4 mt-lg-0">
      <div class="row">
        <div class="col-md-12">
          <div class="user-dashboard-info-box table-responsive mb-0 bg-white p-4 shadow-sm">
            <table class="table manage-candidates-top mb-0">
              <thead>
              <tr>
                <th>Name</th>
                <th>ClassName</th>
                <th>Address</th>
                <th>Date of Birth</th>
                <th class="action">Action</th>
                <th><a href="/customer?action=add" class="text-success" data-toggle="tooltip" title data-original-title="Add"><i class="far fa-plus-square"></i></a></th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="customer" items="${listCustomer}">
                <td class="candidate-list-favourite-time">${customer.getName()}</td>
                <td class="candidate-list-favourite-time">${customer.getClassName()}</td>
                <td class="candidate-list-favourite-time">${customer.getAddress()}</td>
                <td class="candidate-list-favourite-time">${customer.getDateOfBirth()}</td>
                  <td>
                    <ul class="list-unstyled mb-0 d-flex justify-content-end">
                      <li><a href="/customer?action=update&id=${customer.getId()}" class="text-info" data-toggle="tooltip" title data-original-title="Edit"><i class="fas fa-pencil-alt"></i></a></li>
                      <li><a href="/customer?action=delete&id=${customer.getId()}" class="text-danger" data-toggle="tooltip" title data-original-title="Delete"><i class="far fa-trash-alt"></i></a></li>
                    </ul>
                  </td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>
<!-- MAIN -->
</section>
</body>
</html>
