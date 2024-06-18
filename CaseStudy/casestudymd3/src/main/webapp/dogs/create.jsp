<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<div class="container">

    <div class="row justify-content-center mt-4">
        <form class="col-md-6" action="/dog?action=create" method="post">
            <h1 class="">Create dog</h1>
            <div class="form-group">
                <label for="txtId">Dog ID</label>
                <input type="text" class="form-control" name="dogID" id="txtId">
            </div>
            <div class="form-group">
                <label for="txtName">Dog Name</label>
                <input type="text" class="form-control" name="dogName" id="txtName">
            </div>
<%--            <div class="form-check form-check-inline">--%>
<%--                <label class="form-check-label">--%>
<%--                    <input class="form-check-input" type="radio" name="dogType" id="txtPhuQuoc" value="1"> Chó Phú Quốc--%>
<%--                </label>--%>
<%--            </div>--%>
<%--            <div class="form-check form-check-inline">--%>
<%--                <label class="form-check-label">--%>
<%--                    <input class="form-check-input" type="radio" name="dogType" id="txtPoodle" value="2"> Chó Poodle--%>
<%--                </label>--%>
<%--            </div>--%>
<%--            <div class="form-check form-check-inline">--%>
<%--                <label class="form-check-label">--%>
<%--                    <input class="form-check-input" type="radio" name="dogType" id="txtHusky" value="3"> Chó Husky--%>
<%--                </label>--%>
<%--            </div>--%>
            <div class="form-group">
                <label for="txtType">Dog Type</label>
                <input type="text" class="form-control" name="dogType" id="txtType">
            </div>
            <div class="form-group">
                <label for="txtColor">Fur Color</label>
                <input type="text" class="form-control" name="dogColor" id="txtColor">
            </div>
            <div class="form-group">
                <label for="txtImage">Image</label>
                <input type="text" class="form-control" name="dogImage" id="txtImage">
            </div>
            <div class="form-group">
                <label for="txtPrice">Price</label>
                <input type="text" class="form-control" name="dogPrice" id="txtPrice">
            </div>
            <div class="form-group">
                <label for="txtQuantity">Quantity</label>
                <input type="text" class="form-control" name="dogQuantity" id="txtQuantity">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Create</button>
            </div>
        </form>
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <a class="btn btn-warning" role="button" href="/dog?action=backlist">Back</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>