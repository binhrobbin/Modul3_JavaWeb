<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/css/bootstrap.css">
    <script src="../static/js/bootstrap.js"></script>
    <script src="../static/myJS/btnBack.js"></script>
</head>
<body>
    <div class="container" id="listID">
        <h1>Danh sách Booking</h1>
        <a class="btn btn-warning" href="/index.jsp" role="button">Back</a>
<%--        <a class="btn btn-success" href="/dog?action=create" role="button">Create</a>--%>
        <table class="table">
            <thead>
            <tr>
                <th>Booking ID</th>
                <th>User ID</th>
                <th>Booking day</th>
                <th>View</th>
<%--                <th>Delete</th>--%>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${bookingList}" var="booking">
                    <tr>
                        <td>${booking.getId()}</td>
                        <td>${booking.getUser_id()}</td>
                        <td>${booking.getBooking_day()}</td>
                        <td>
                            <a class="btn btn-primary" href="/booking-servlet?action=view&viewBookingID=${booking.getId()}" role="button">View my Booked</a>
                        </td>
<%--                        <td>--%>
<%--                            <a class="btn btn-danger" href="/booking-servlet?action=delete&deleteBookingID=${booking.getId()}" role="button">Delete</a>--%>
<%--                        </td>--%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div  class="container" id="listBookedInBookingID">
        <h1>List Booked in Booking ID: ${viewBookingId}</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col"> Name</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Total</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${keySetBooking}" var="key">
                <tr>
                    <td>${dogMapBooking.get(key).name}</td>
                    <td>${dogMapBooking.get(key).price}</td>
                    <td>${dogMapBooking.get(key).quantity}</td>
                    <td>${dogMapBooking.get(key).price * dogMap.get(key).quantity}</td>
                    <td>
<%--                        <a class="btn btn-danger" href="#" role="button">Delete</a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
