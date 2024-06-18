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
    <h1>Danh sách Booked</h1>
    <%--        <a class="btn btn-success" href="/dog?action=create" role="button">Create</a>--%>
    <table class="table">
        <thead>
        <tr>
            <th>Booked ID</th>
            <th>Booked day</th>
            <th>Is Payment</th>
            <th>Booking ID</th>
            <th>Dog ID</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bookedList}" var="booked">
            <tr>
                <td>${booked.getId()}</td>
                <td>${booked.getBooked_day()}</td>
                <td>${booked.getIsCheck()}</td>
                <td>${booked.getBooking_id()}</td>
                <td>${booked.getDog_id()}</td>
                <td>
                    <a class="btn btn-danger" href="/booking-servlet?action=delete&deleteID=${booked.getId()}" role="button">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
