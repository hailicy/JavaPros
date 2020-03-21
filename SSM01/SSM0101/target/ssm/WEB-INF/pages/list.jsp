<%--
  Created by IntelliJ IDEA.
  User: haili
  Date: 2020/3/13
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <h3>查询到的所有员工信息：</h3>

<%--    <a>直接看list</a><br />--%>
<%--    ${list}--%>
    <br />
<%--    <a>数据库中所有的信息：</a><br />--%>
    <c:forEach items="${list}" var="account">
        <a>编号：</a>${account.id}<a>， </a>
        <a>姓名：</a>${account.name}<a>， </a>
        <a>工资：</a>${account.money}<a>， </a>
        <a>年龄：</a>${account.age}
        <br />
    </c:forEach>

</body>
</html>
