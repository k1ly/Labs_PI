<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<fieldset>
    <div><a href="urln">URLN</a></div>
    <div><a href="urln?urln=1">URLN = 1</a></div>
    <div><a href="urln?urln=2">URLN = 2</a></div>
    <div><a href="urln.jsp">URLN page</a></div>
</fieldset>
<fieldset>
    <a href="GoCcc">CCC</a>
    <form action="GoCcc" method="post">
        <div>
            <select name="CBean">
                <option value="old">old</option>
                <option value="new">new</option>
            </select>
        </div>
        <div><label>Value1</label></div>
        <div><input name="Value1"/></div>
        <div><label>Value2</label></div>
        <div><input name="Value2"/></div>
        <div><label>Value3</label></div>
        <div><input name="Value3"/></div>
        <div><input type="submit" value="CCC"/></div>
    </form>
</fieldset>
</body>
</html>
