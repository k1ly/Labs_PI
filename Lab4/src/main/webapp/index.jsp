<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<%! LocalDateTime date = LocalDateTime.now();%>
<h1>
    <%
        int hours = date.getHour();
        String partOfDay;
        if (hours <= 5)
            partOfDay = "night";
        else if (hours <= 11)
            partOfDay = "morning";
        else if (hours <= 17)
            partOfDay = "afternoon";
        else partOfDay = "evening";
    %>
    <%= "Good " + partOfDay %>
</h1>
<table style="border: 1px solid black">
    <thead>
    <tr>
        <th>Date</th>
        <th>Day of week</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < 7; i++) {
        LocalDate day = date.toLocalDate().plusDays(i); %>
    <tr>
        <td style="border: 1px solid slategray">
            <%= day.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) %>
        </td>
        <td style="border: 1px solid slategray">
            <%= day.getDayOfWeek().getValue() %>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<fieldset>
    <button onclick="press()">
        press
    </button>
    <div id="partOfDay1"></div>
    <div id="partOfDay2"></div>
    <%--    <jsp:forward page="afternoon"/>--%>
</fieldset>
<script>
    function press() {
        <% switch (partOfDay) {
case "night": %>
        document.getElementById('partOfDay1').innerHTML = `<%@ include file="night.jsp" %>`;
        document.getElementById('partOfDay2').innerHTML = `<jsp:include page="night.jsp"/>`;
        <% break;
case "morning": %>
        document.getElementById('partOfDay1').innerHTML = `<%@ include file="morning.jsp" %>`;
        document.getElementById('partOfDay2').innerHTML = `<jsp:include page="morning.jsp"/>`;
        <% break;
case "afternoon": %>
        document.getElementById('partOfDay1').innerHTML = `<%@ include file="afternoon.jsp" %>`;
        document.getElementById('partOfDay2').innerHTML = `<jsp:include page="afternoon"/>`;
        <% break;
case "evening": %>
        document.getElementById('partOfDay1').innerHTML = `<%@ include file="evening.jsp" %>`;
        document.getElementById('partOfDay2').innerHTML = `<jsp:include page="evening.jsp"/>`;
        <% } %>
    }
</script>
<fieldset>
    <legend>GET</legend>
    <div><a href="GoJjj">JJJ</a></div>
</fieldset>
<fieldset>
    <legend>POST</legend>
    <form action="GoJjj" method="post">
        <input type="submit" value="JJJ"/>
    </form>
</fieldset>
</body>
</html>
