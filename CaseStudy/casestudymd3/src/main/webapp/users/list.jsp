<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <style>
        th,td{
            text-align: center;
            vertical-align: middle;
            width: 7%;
        }
    </style>
<%--    <link rel="stylesheet" href="/static/thayTrung/bootstrap413/css/bootstrap.min.css" />--%>
<%--    <link rel="stylesheet" href="/static/thayTrung/datatables/css/dataTables.bootstrap4.min.css" />--%>
</head>
<body>
<h1 align="center">Users information</h1>
<table align="center" class="table-responsive table w-75" style="margin-top: 4%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Username</th>
        <th>Money</th>
        <th>Role</th>
        <th>Image</th>
        <th></th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.money}</td>
            <td>${user.role}</td>
            <td><img src="../static/data/user/${user.image}" height="100" width="100"></td>
            <td><a  class="btn btn-warning" href="/user?action=edit&id=${user.id}" role="button">Edit</a></td>
            <td>
                <form action="/user?action=delete&id=${user.id}" method="post">
                <button type="submit" class="btn btn-danger" >Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" href="/user?action=create&check=0" role="button" style="margin-left: 75%">Create</a>
<a class="btn btn-secondary" href="/user?action=back" role="button" style="margin-left: 75%">Back</a>
<%--<script src="/static/thayTrung/jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="/static/thayTrung/datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="/static/thayTrung/datatables/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script>--%>
<%--    $(document).ready(function() {--%>
<%--        $('#tableStudent').dataTable( {--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            "pageLength": 5--%>
<%--        } );--%>
<%--    } );--%>
<%--</script>--%>

<c:if test="${username != null}">
    <p style="color: green;text-align: center">Are you sure to delete username ='${username}':&nbsp;&nbsp;<a href="/user?action=delete&id=${id}"  >YES</a>&nbsp;&nbsp;or&nbsp;&nbsp;<a href="/user" >NO</a></p>

</c:if>
</body>
</html>
