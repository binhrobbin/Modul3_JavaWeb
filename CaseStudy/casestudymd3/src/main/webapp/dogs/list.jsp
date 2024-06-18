<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/css/bootstrap.css">
    <script src="../static/js/bootstrap.js"></script>
</head>
<body>
    <div class="container" id="listID">
        <h1>Danh sách Thú cưng</h1>
        <a class="btn btn-success" href="/dog?action=create" role="button">Create</a>
        <a class="btn btn-warning" href="/users/admin.jsp" role="button">Back</a>
        <table class="table">
            <thead>
            <tr>
                <th>Dog ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Color</th>
                <th>Image</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Button</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${dogList}" var="dog">
                    <tr>
                        <td>${dog.getId()}</td>
                        <td><c:out value="${dog.name}" /></td>
                        <td>${dog.type}</td>
                        <td>${dog.color}</td>
                        <td>
                            <img src="../static/data/card/${dog.image}" width="100px">
                        </td>
                        <td>${dog.price}</td>
                        <td>${dog.quantity}</td>
                        <td>
                            <a class="btn btn-success" href="/dog?action=edit&editID=${dog.getId()}" role="button">Edit</a>
                            <a class="btn btn-danger" href="/dog?action=delete&deleteID=${dog.getId()}" role="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
