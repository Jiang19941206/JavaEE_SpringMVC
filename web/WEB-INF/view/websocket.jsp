<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/26
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>websocket测试</title>
</head>
<body>
    用户名：<input type="text" readonly value="${userName}" id="userName">
    <br/>
    我的消息：<input type="text" readonly value="" id="message" style="width: 300px;">
</body>
<script>
    var websocket = null;
    var host = document.location.host;
    // 获得当前登录人员的userName
    var username = '${userName}';

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        // 浏览器支持Websocket
        websocket = new WebSocket('ws://' + host + '/webSocket/' + username);
    } else {
        // 浏览器 Not support websocket
    }

    //WebSocket连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //WebSocket连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    };

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
        //alertTip(event.data);
        // websocket.close();
        // alert("webSocket已关闭！")
    };

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    };

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    };

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').value = innerHTML;
    }
</script>
</html>
