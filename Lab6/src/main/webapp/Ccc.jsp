<%@ page import="by.belstu.it.lyskov.lab6.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<% CBean atrCBean = (CBean) request.getServletContext().getAttribute("atrCBean");%>
<h1>
    Value1: <%= atrCBean.getValue1() %>
</h1>
<h1>
    Value2: <%= atrCBean.getValue2() %>
</h1>
<h1>
    Value3: <%= atrCBean.getValue3() %>
</h1>
</body>
</html>
