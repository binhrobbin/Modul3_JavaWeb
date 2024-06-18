<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    .login {
      height:180px; width:230px;
      margin:0;
      padding:10px;
      border:1px #CCC solid;
    }
    .login input {
      padding:5px; margin:5px
    }
  </style>
</head>
<body>
<form action="/login" method="get">
  <div class="login">
    <h2>Login</h2>
    <input type="text" size="30" placeholder="username" name="user-name">
    <input type="password" size="30" placeholder="password" name="pass-word">
    <input type="submit"  value="Sign in">
  </div>
</form>
</body>
</html>