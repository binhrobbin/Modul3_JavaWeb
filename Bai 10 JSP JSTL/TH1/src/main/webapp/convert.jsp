
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%!
    float vnd;
%>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    vnd = rate*usd;
    request.setAttribute("vndt",vnd);
%>

<h1>Rate: <%=rate%></h1>
<h1>USD: <%=usd%></h1>
<h1>VND: ${vndt}</h1>
<h1>VND: <%=vnd%></h1>
</body>
</html>
