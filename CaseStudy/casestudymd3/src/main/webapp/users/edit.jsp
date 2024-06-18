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
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-3">
        <form class="col-md-6" action="/user?action=edit&id=${user.id}" method="post">
            <h1 class="" align="center">Edit user</h1>
            <c:if test="${message != null}"><br><br>
                <p style="color: green;text-align: center">${message}</p>
            </c:if>
            <div class="form-group">
                <label for="txtName">Name</label>
                <input type="text" class="form-control" name="name" value="${user.name}" id="txtName">
            </div>
            <div class="form-group">
                <label for="txtType">UserName&nbsp;&nbsp;</label>
                <c:if test="${message1 != null}">
                    <label style="color: red;text-align: center"><i> ${message1}</i></label>
                </c:if>
                <input type="text" class="form-control" name="username" value="${user.username}" id="txtType">
            </div>
            <div class="form-group">
                <label for="txtColor">PassWord</label>
                <input type="text" class="form-control" name="password" value="${user.password}" id="txtColor">
            </div>
            <div class="form-group">
                <label for="txtDes">Money</label>
                <input type="text" class="form-control" name="money" value="${user.money}" id="txtDes">
            </div>
            <div class="form-group">
                <label for="txtMoney">Role</label>
                <select name="role" class="form-control" id="txtMoney">
                <c:if test="${user.role == 'admin'}">
                    <option class="form-control" selected>admin</option>
                    <option class="form-control" >customer</option>
                </c:if>
                <c:if test="${user.role == 'customer'}">
                    <option class="form-control" >admin</option>
                    <option class="form-control" selected>customer</option>
                </c:if>
                </select>
            </div>
            <div class="form-group">
                <label for="txtImage">Image</label>
                <input type="text" class="form-control" name="image" value="${user.image}" id="txtImage">
            </div>
            <div class="form-group mt-4" align="center">
                <button class="btn btn-success" role="button" type="submit">Save</button>
                <a id="" class="btn btn-dark" href="/user" role="button">Cancel</a>
            </div>
        </form>

    </div>
</div>
</body>
</html>