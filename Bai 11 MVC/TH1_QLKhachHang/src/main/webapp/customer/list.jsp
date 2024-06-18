<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer list</title>
    <style>
        p{
            display: inline;
        }
    </style>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="customers?action=create">Create new customer</a>
</p>
<form action="/customers?action=search" method="post">
<input type="text" name="input" placeholder="name" value="${nameSearch}"><input type="submit" value="Search">
</form>
<p>
    <c:if test='${message != null}'>
        <span class="message">${message}</span>
    </c:if>
</p>
<table class="table" border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
<%--    <tbody>--%>
<%--    <c:forEach items='${requestScope["customers"]}' var="customer">--%>
<%--    <tr>--%>
<%--        <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a> </td>--%>
<%--        <td>${customer.getEmail()}</td>--%>
<%--        <td>${customer.getAddress()}</td>--%>
<%--        <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>--%>
<%--        <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>--%>
<%--    </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
    <tbody>
    <c:forEach items='${customers}' var="customer">
        <tr>
            <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a> </td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
