<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <script src="/static/js/bootstrap.js"></script>
    <style>
        div{
            text-align: center;
        }
    </style>
</head>
<body>
<c:if test="${username != null}">
    <h1 style="text-align: center">Chào mừng "${username}"</h1>
</c:if>
<div class="d-grid gap-4 col-3 mx-auto" style="margin-top: 10%">
    <a class="btn btn-success btn-lg" href="/user" role="button">Quản lý User</a>
    <a class="btn btn-info btn-lg" href="/dog" role="button">Quản lý Dog</a>
    <form action="/home" method="post">
        <button class="btn btn-secondary btn-lg" role="button">Đăng Xuất</button>
    </form>
</div>
</body>
</html>
