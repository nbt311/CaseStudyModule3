<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/CSS/userList.css">
    <title>User Management Application</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />
<div class="container mt-3 mb-4">
    <div class="col-lg-9 mt-4 mt-lg-0">
        <div class="row">
            <div class="col-md-12">
                <div class="user-dashboard-info-box table-responsive mb-0 bg-white p-4 shadow-sm">
                    <table class="table manage-candidates-top mb-0">
                        <thead>
                        <tr>
                            <th>User Name</th>
                            <th class="text-center">Role</th>
                            <th class="action text-right">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${listUser}">
                        <tr class="user-list">
                            <td class="title">
                                <div class="thumb">
                                    <img class="img-fluid" value="${user.getAvatar()}"/>
                                </div>
                                <div class="candidate-list-details">
                                    <div class="candidate-list-info">
                                        <div class="candidate-list-title">
                                            <h5 class="mb-0">${user.getName()}</h5>
                                        </div>
                                        <div class="candidate-list-option">
                                            <ul class="list-unstyled">
                                                <li><i class="fas fa-filter pr-1"></i>Information Technology</li>
                                                <li><i class="fas fa-map-marker-alt pr-1"></i>Rolling Meadows, IL 60008</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td class="candidate-list-favourite-time text-center">
                                <a class="candidate-list-favourite order-2 text-danger" href="#"><i class="fas fa-heart"></i></a>
                                <span class="candidate-list-time order-1">${user.getRole()}</span>
                            </td>
                            <td>
                                <ul class="list-unstyled mb-0 d-flex justify-content-end">
                                    <li><a href="#" class="text-primary" data-toggle="tooltip" title data-original-title="view"><i class="far fa-eye"></i></a></li>
                                    <li><a href="#" class="text-info" data-toggle="tooltip" title data-original-title="Edit"><i class="fas fa-pencil-alt"></i></a></li>
                                    <li><a href="#" class="text-danger" data-toggle="tooltip" title data-original-title="Delete"><i class="far fa-trash-alt"></i></a></li>
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

<%--<center>--%>
<%--    <h1>User Management</h1>--%>
<%--    <h2>--%>
<%--        <a href="/admin?action=add">Add New User</a>--%>
<%--    </h2>--%>
<%--</center>--%>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>
<%--        <caption><h2>List of Users</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>Name</th>--%>
<%--            <th>Email</th>--%>
<%--            <th>phone</th>--%>
<%--            <th>avatar</th>--%>
<%--            <th>username</th>--%>
<%--            <th>password</th>--%>
<%--            <th>role</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="user" items="${listUser}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${user.getName()}"/></td>--%>
<%--                <td><c:out value="${user.getEmail()}"/></td>--%>
<%--                <td><c:out value="${user.getPhone()}"/></td>--%>
<%--                <td><c:out value="${user.getAvatar()}"/></td>--%>
<%--                <td><c:out value="${user.getUsername()}"/></td>--%>
<%--                <td><c:out value="${user.getPassword()}"/></td>--%>
<%--                <td><c:out value="${user.getRole()}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/admin?action=update&id=${user.getId()}">Update</a>--%>
<%--                    <a href="/admin?action=delete&id=${user.getId()}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
</body>
</html>