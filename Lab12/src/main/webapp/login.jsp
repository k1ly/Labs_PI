<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="j_security_check" method="post">
    <div>Username: <input name="j_username"/></div>
    <div>Password: <input type="password" name="j_password"/></div>
    <input type="submit" value="sign in"/>
</form>
</body>
</html>
