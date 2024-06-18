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
        <form class="col-md-6" action="/student?action=edit" method="post">
            <h1 class="">Create student</h1>
            <div class="form-group">
                <label for="txtId">Student ID</label>
                <input type="text" class="form-control" name="studentId" id="txtId" value="${student.id}">
            </div>
            <div class="form-group">
                <label for="txtName">Student Name</label>
                <input type="text" class="form-control" name="studentName" id="txtName" value="${student.name}">
            </div>
            <c:if test="${student.gender == 1}" >
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender" id="txtMale" value="1" checked> Male
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender" id="txtFemale" value="0"> Female
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender" id="txtLGBT" value="2"> LGBT
                    </label>
                </div>
            </c:if>
            <c:if test="${student.gender == 0}" >
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender"  value="1" > Male
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender"  value="0" checked> Female
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender"  value="2"> LGBT
                    </label>
                </div>
            </c:if>
            <c:if test="${student.gender == 2}" >
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender"  value="1"> Male
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender"  value="0"> Female
                    </label>
                </div>
                <div class="form-check form-check-inline">
                    <label class="form-check-label">
                        <input class="form-check-input" type="radio" name="studentGender"  value="2" checked> LGBT
                    </label>
                </div>
            </c:if>
            <div class="form-group">
                <label for="txtPoint">Student Point</label>
                <input type="text" class="form-control" name="studentPoint" id="txtPoint" value="${student.point}">
            </div>
            <div class="form-group">
                <label for="txtImage">Student Image</label>
                <input type="text" class="form-control" name="studentImage" id="txtImage" value="${student.image}">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Edit</button>
                <a id="" class="btn btn-dark" href="/student" role="button">Cancel</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
