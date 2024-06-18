<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<fieldset>
  <legend>Calculator</legend>
  <form action="/calculate" method="post">
  <table class="table">

    <tr>
      <th>First operand: </th>
      <th><input type="number" name="first"> </th>
    </tr>
    <tr>
      <td>Operator: </td>
      <td><select name="op">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
      </select> </td>
    </tr>
    <tr>
      <td>Second operand: </td>
      <td><input type="number" name="second"> </td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Calculate"/></td>
    </tr>
  </table>
  </form>
</fieldset>
</body>
</html>