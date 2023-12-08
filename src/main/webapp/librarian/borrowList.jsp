<%--
  Created by IntelliJ IDEA.
  User: FPT
  Date: 12/8/2023
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<tr>
  <th>Id </th>
  <th>Customer Name</th>
  <th>Book Name</th>
</tr>
  <c:forEach items="${listBorrow}" var="borrow">
    <tr>
      <td>${borrow.getId()}</td>
      <td>${borrow.getCustomerName()}</td>
      <td>${borrow.getBookName()}</td>
      <td><a href="borrow?action=view&id=${borrow.getId()}"></a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
