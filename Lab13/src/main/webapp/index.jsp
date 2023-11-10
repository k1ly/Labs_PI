<%@ page import="by.belstu.it.lyskov.lab13.FileNameList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="MsDoc" method="post" enctype="multipart/form-data">
    <div>
        <input type="file" accept="application/msword" name="file"/>
    </div>
    <div>
        <input type="submit" value="upload"/>
    </div>
</form>
<%
    String docDir = request.getServletContext().getInitParameter("doc-dir");
    FileNameList fileNameList = new FileNameList(docDir, "doc");
    for (int i = 0; i < fileNameList.fileNameList.length; i++) {
        String fileName = fileNameList.fileNameList[i];
%>
<div>
    <a href="MsDoc?file=<%=fileName%>">
        <%=fileName%>
    </a>
</div>
<%}%>
</body>
</html>
