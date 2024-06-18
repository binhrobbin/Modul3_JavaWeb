<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
<%--    <form action="users?action=arr" method="post">--%>
    <form action="users?action=country" method="post">
    <label>
        <select name="countrySearch">
        <c:forEach var="set" items="${setList}">
            <c:if test="${search == set}">
            <option  value="${set}" selected>${set}</option>
            </c:if>
            <c:if test="${search != set}">
                <option  value="${set}" >${set}</option>
            </c:if>
        </c:forEach>
        </select>
    </label>
        <button type="submit">Search</button>
    </form>
<%--    <button type="submit">Arrangement</button>--%>
<%--    </form>--%>
</div>
</body>
</html>
