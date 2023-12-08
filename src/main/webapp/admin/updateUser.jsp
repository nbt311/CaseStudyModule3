<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/6/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Edit</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="CSS/updateUser.css">
</head>
<body>
<div class="container bootstrap snippets bootdey">
  <h1 class="text-primary">Edit Profile</h1>
  <hr>
  <div class="row">

    <div class="col-md-3">
      <div class="text-center">
        <img src="${user.getAvatar()}" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6>Upload a different photo...</h6>
        <input type="file" class="form-control">
      </div>
    </div>

    <div class="col-md-9 personal-info">
      <div class="alert alert-info alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a>
        <i class="fa fa-coffee"></i>
        This is an <strong>.alert</strong>. Use this to show important messages to the user.
      </div>
      <h3>Personal info</h3>
      <form class="form-horizontal" role="form" method="post">
        <div class="form-group">
          <label class="col-lg-3 control-label">Name:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" name="name" value="${user.getName()}">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" name="email" value="${user.getEmail()}" readonly >
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Phone:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" name="phone" value="${user.getPhone()}">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Username:</label>
          <div class="col-lg-8">
            <input class="form-control" type="text" name="username" value="${user.getUsername()}">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Password:</label>
          <div class="col-lg-8">
            <input class="form-control" name="password" type="text" value="">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label"></label>
          <div class="col-lg-6">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
          <div class="form-group">
          <label class="col-lg-8 control-label"></label>
          <div class="col-lg-5">
            <button type="submit" class="btn btn-danger"><a href="admin?action=list">Exit</a></button>
          </div>
          </div>
      </form>
    </div>
  </div>
</div>
<hr>
</body>
