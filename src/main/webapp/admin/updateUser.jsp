<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/6/2023
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="admin?action=list">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit User
        </h2>
      </caption>
      <c:if test="${user != null}">
        <input type="hidden" name="id" value="<c:out value='${user.getId()}' />"/>
      </c:if>
      <tr>
        <th>User Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="<c:out value='${user.getName()}' />"
          />
        </td>
      </tr>
      <tr>
        <th>User Email:</th>
        <td>
          <input type="text" name="email" size="45"
                 value="<c:out value='${user.getEmail()}' />"
          />
        </td>
      </tr>
      <tr>
        <th>Phone:</th>
        <td>
          <input type="text" name="phone" size="15"
                 value="<c:out value='${user.getPhone()}' />"
          />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
