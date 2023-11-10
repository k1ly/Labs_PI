<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<button onclick="connect()">START</button>
<button onclick="disconnect()">STOP</button>
<div id="output"></div>
<script>
    let websocket;

    function connect() {
        websocket = new WebSocket("ws://localhost:8080${pageContext.request.contextPath}/websocket");
        websocket.onmessage = function (event) {
            document.getElementById('output').innerHTML = event.data;
        };
    }

    function disconnect() {
        if (websocket)
            websocket.close();
    }
</script>
</body>
</html>
