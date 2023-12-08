<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/7/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
  <table>
    <tr>
      <th>Name</th>
      <th>ClassName</th>
      <th>Address</th>
      <th></th>Date Of Birth</tr>
    <c:forEach items="${listCustomer}" var = "customer">
    <tr>
      <td>${customer.getName()}</td>
      <td>${customer.getClassName()}</td>
      <td>${customer.getAddress()}</td>
      <td>${customer.getDateOfBirth()}</td>
      <td>
        <a href="/customer?action=update&id=${customer.getId()}">Update</a>
<%--        <a href="/customer?action=delete&id=${customer.getId()}">Delete</a>--%>
      </td>
    </tr>
    </c:forEach>
  </table>
</head>
<body>

</body>
</html>
