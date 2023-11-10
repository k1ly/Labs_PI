<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Urln</title>
</head>
<body>
<h1>
    URL1: <%= request.getServletContext().getInitParameter("URL1") %>
</h1>
<h1>
    URL2: <%= request.getServletContext().getInitParameter("URL2") %>
</h1>
</body>
</html>
