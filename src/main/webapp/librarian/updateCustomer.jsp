<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/7/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="CSS/addCustomer.css">
</head>
<body>
<div class="container h-100">
    <div class="row h-100">
        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
            <div class="d-table-cell align-middle">
                <div class="text-center mt-4">
                    <h1 class="h2">Edit Customer</h1>
                    <p class="lead">
                        Start editing the customers.
                    </p>
                </div>
                <div class="card">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <form method="post">
                                <div class="form-group">
                                    <input type="text" name="id" style="display: none";>
                                    <label>Name</label>
                                    <input class="form-control form-control-lg" type="text" name="name" value="${customer.getName()}">
                                </div>
                                <div class="form-group">
                                    <label>Class</label>
                                    <input class="form-control form-control-lg" type="text" name="className" value="${customer.getClassName()}">
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input class="form-control form-control-lg" type="text" name="address" value="${customer.getAddress()}">
                                </div>
                                <div class="form-group">
                                    <label>Date Of Birth</label>
                                    <input class="form-control form-control-lg" type="text" name="dateOfBirth" value="${customer.getDateOfBirth()}">
                                </div>
                                <div class="text-center mt-3">
                                    <button type="submit" class="btn btn-lg btn-primary">Edit</button>
                                    <a href="/customer" class="btn btn-lg btn-danger">Back</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
