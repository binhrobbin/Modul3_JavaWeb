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
Product Description:  <input type="text" name="des" value="${desc}"><br><br>
List Price: :  <input type="number" name="price" value="${price}"><br><br>
Discount Percent:  <input type="number" name="dis" value="${percent}"><br><br>
  <button type="submit">Calculate Discount</button><br><br>
  Discount Amount: ${price * percent * 0.01}<br><br>
  Discount Price: ${price - (price * percent * 0.01)}
</form>
</body>
</html>