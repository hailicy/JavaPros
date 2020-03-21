<%--
  Created by IntelliJ IDEA.
  User: haili
  Date: 2020/3/13
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM</title>
</head>
<body>

    <a href="account/findAll">查询数据库所有账户</a>
    <br />
    <br />
    <a>保存账户到数据库</a>
    <form action="account/save" method="post">
        姓名：<input type="text" name="name" /><br />
        工资：<input type="text" name="money" /><br />
        年龄：<input type="text" name="age" /><br />
        <input type="submit" value="保存" />
    </form>
</body>
</html>
