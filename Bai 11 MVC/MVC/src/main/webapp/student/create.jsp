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
        <form class="col-md-6" action="/student?action=create" method="post">
            <h1 class="">Create student</h1>
            <div class="form-group">
                <label for="txtId">Student ID</label>
                <input type="text" class="form-control" name="studentId" id="txtId">
            </div>
            <div class="form-group">
                <label for="txtName">Student Name</label>
                <input type="text" class="form-control" name="studentName" id="txtName">
            </div>
            <div class="form-check form-check-inline">
                <label class="form-check-label">
                    <input class="form-check-input" type="radio" name="studentGender" id="txtMale" value="1"> Male
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
            <div class="form-group">
                <label for="txtPoint">Student Point</label>
                <input type="text" class="form-control" name="studentPoint" id="txtPoint">
            </div>
            <div class="form-group">
                <label for="txtImage">Student Image</label>
                <input type="text" class="form-control" name="studentImage" id="txtImage">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Create</button>
                <button class="btn btn-warning" role="button">Cancel</button>
            </div>
        </form>

    </div>
</div>

</body>
</html>