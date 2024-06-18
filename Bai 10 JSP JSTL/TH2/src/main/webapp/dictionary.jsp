<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!

%>

<%
    Map<String, String> dic = new HashMap<>();
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");
    String search1 = request.getParameter("search");
    String result = dic.get(search1);

    PrintWriter out1 = response.getWriter();
    if (result != null) {
        System.out.println();
        out1.println("Word: " + search1);
        out1.println("Result: " + result);
    } else {
        out1.println("Not found");
    }
%>
</body>
</html>
