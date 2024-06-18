<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    input {
      border: none;
    }
  </style>
</head>
<body>
<form action="/handle" method="post">
Product Description:  <input type="text" name="des"><br><br>
List Price: :  <input type="number" name="price"><br><br>
Discount Percent:  <input type="number" name="dis"><br><br>
  <button type="submit">Calculate Discount</button>
</form>
</body>
</html>