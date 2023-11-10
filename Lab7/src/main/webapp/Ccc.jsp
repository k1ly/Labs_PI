<%@ page import="by.belstu.it.lyskov.lab7.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<% CBean requestAtrCBean = (CBean) request.getAttribute("atrCBean");%>
<% CBean sessionAtrCBean = (CBean) request.getSession().getAttribute(request.getSession().getId());%>
<h1>
    Request Value1: <%= requestAtrCBean.getValue1() %>
</h1>
<h1>
    Request Value2: <%= requestAtrCBean.getValue2() %>
</h1>
<h1>
    Request Value3: <%= requestAtrCBean.getValue3() %>
</h1>
<h1>
    Session Value1: <%= sessionAtrCBean.getValue1() %>
</h1>
<h1>
    Session Value2: <%= sessionAtrCBean.getValue2() %>
</h1>
<h1>
    Session Value3: <%= sessionAtrCBean.getValue3() %>
</h1>
</body>
</html>
