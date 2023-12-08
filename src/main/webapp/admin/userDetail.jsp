<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/8/2023
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Detail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/userDetail.css">
</head>
<body>
<div class="container bootstrap snippets bootdey">
    <div class="panel-body inf-content">
        <div class="row">
            <div class="col-md-4">
                <img alt="" style="width:600px;" title="" class="img-circle img-thumbnail isTooltip" src="${user.getAvatar()}" data-original-title="Usuario">
                <ul title="Ratings" class="list-inline ratings text-center">
                    <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                </ul>
            </div>
            <div class="col-md-6">
                <strong>Information</strong><br>
                <div class="table-responsive">
                    <table class="table table-user-information">
                        <tbody>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-asterisk text-primary"></span>
                                    Id
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getId()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-user  text-primary"></span>
                                    Name
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getName()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-envelope text-primary"></span>
                                    Email
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getEmail()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-phone-alt text-primary"></span>
                                    Phone
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getPhone()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-star text-primary"></span>
                                    Username
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getUsername()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-star-empty text-primary"></span>
                                    Password
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getPassword()}
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>
                                    <span class="glyphicon glyphicon-signal text-primary"></span>
                                    Role
                                </strong>
                            </td>
                            <td class="text-primary">
                                ${user.getRole()}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
