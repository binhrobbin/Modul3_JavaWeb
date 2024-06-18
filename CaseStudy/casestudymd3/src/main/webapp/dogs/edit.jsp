<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.css">
    <style>
        label {
            font-weight: bolder;
        }
        span {
            font-weight: bolder;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="row justify-content- mt-4">
        <div class="col-md-6">
            <div class="card h-100">
                <div class="card-body">
                    <div class="form-group">
                        <label style="font-weight: bolder">Dog ID: ${editDog.getId()}</label>
                    </div>
                    <h5 class="card-title"> <span>Name: </span> ${editDog.getName()}</h5>
                    <p class="card-text"><span>Type: </span>: ${editDog.type}</p>
                    <p class="card-text"><span>Color: </span>: ${editDog.color}</p>
                    <p class="card-text"><span>Price: </span>: ${editDog.price}</p>
                    <p class="card-text"><span>Quantity: </span>: ${editDog.quantity}</p>
                </div>
                <img src="static/data/card/${editDog.image}" class="card-img-top" alt="...">
            </div>
        </div>
        <form class="col-md-6" action="/dog?action=edit&editID=${editID}" method="post">
            <h1 class="">Edit dog</h1>
            <div class="form-group">
                <label style="font-weight: bolder">Dog ID: ${editID}</label>
            </div>
            <br>
            <div class="form-group">
                <label for="txtName">Dog Name</label>
                <input type="text" class="form-control" name="editName" id="txtName" required>
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
                <input type="text" class="form-control" name="editType" id="txtType" required>
            </div>
            <div class="form-group">
                <label for="txtColor">Fur Color</label>
                <input type="text" class="form-control" name="editColor" id="txtColor" required>
            </div>
            <div class="form-group">
                <label for="txtImage">Image</label>
                <input type="text" class="form-control" name="editImage" id="txtImage"required>
            </div>
            <div class="form-group">
                <label for="txtPrice">Price</label>
                <input type="text" class="form-control" name="editPrice" id="txtPrice"required>
            </div>
            <div class="form-group">
                <label for="txtQuantity">Quantity</label>
                <input type="text" class="form-control" name="editQuantity" id="txtQuantity"required>
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Edit</button>
                <button class="btn btn-warning" role="button" href="/dog">Cancel</button>
            </div>
        </form>

    </div>
</div>

</body>
</html>