<%--
  Created by IntelliJ IDEA.
  User: hejx
  Date: 2021/8/22
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>lastName</td>
        <td>email</td>
        <td>gender</td>
    </tr>
    <c:forEach items="${emps }" var="emp">
        <tr>
            <td>${emp.id }</td>
            <td>${emp.lastName }</td>
            <td>${emp.email }</td>
            <td>${emp.gender }</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
