<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp" />

<h1>Student List</h1>
<a id="" class="btn btn-success" href="/student?action=create" role="button">Create</a>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
        <th>Result</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><c:out value="${student.name}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${student.gender == 0}">Female</c:when>
                        <c:when test="${student.gender == 1}">Male</c:when>
                        <c:otherwise>LGBT</c:otherwise>
                    </c:choose>
                </td>
                <td>${student.point}</td>
                <td>
                    <c:if test="${student.point >= 75}">Pass</c:if>
                    <c:if test="${student.point < 75}">Fail</c:if>
                </td>
                <td>
                    <img src="/static/img/${student.image}" width="50px">
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
