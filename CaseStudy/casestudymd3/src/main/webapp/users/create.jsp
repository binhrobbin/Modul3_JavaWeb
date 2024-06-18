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
        <form class="col-md-6" action="/user?action=create&check=${check}" method="post">
            <h1 class="" align="center">Create new user</h1>
            <c:if test="${message != null}">
                <p style="color: green;text-align: center;font-size: large">${message}</p>
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
                <label for="txtImage">Image</label>
                <select name="image" class="form-control" id="txtImage" value="${user.image}">
                    <option></option>
                    <option>avt0.jpg</option>
                    <option>avt1.jpg</option>
                    <option>avt2.jpg</option>
                    <option>avt3.jpg</option>
                    <option >avt4p.png</option>
                    <option  >avt5p.png</option>
                </select>
            </div>
            <div class="form-group mt-4" align="center">
                <button class="btn btn-primary" role="button" type="submit">Create</button>
                <c:if test="${check == '0'}">
                    <a id="" class="btn btn-dark" href="/user" role="button">Cancel</a>
                </c:if>
                <c:if test="${check == '1'}">
                    <a id="" class="btn btn-dark" href="/login" role="button">Cancel</a>
                </c:if>
                <c:if test="${check == '2'}">
                    <a id="" class="btn btn-dark" href="/home" role="button">Cancel</a>
                </c:if>
            </div>
        </form><br><br>

    </div>
</div>

</body>
</html>