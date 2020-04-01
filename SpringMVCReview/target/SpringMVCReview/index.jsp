<%--
  Created by IntelliJ IDEA.
  User: haili
  Date: 2020/3/30
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <h1>主页</h1>

    <a href="hello/hello">欢迎页</a>
    <br />
    <a href="test/up">上传测试</a>
    <br />
    <a href="test/bangding?username=xyz&age=45">请求参数绑定</a>
    <br />
    <a href="test/json">json</a>
    <br />
    <a href="test/testforward">请求转发success</a>
    <br />
    <a href="test/testredirect">重定向success</a>
</body>
</html>
