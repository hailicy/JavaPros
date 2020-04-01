<%--
  Created by IntelliJ IDEA.
  User: haili
  Date: 2020/3/30
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js" ></script>
    <script>
        //页面加载，绑定单机事件
        $(function(){
            $("#btn").click(function(){
                //alert("hello btn!");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"test/testajax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"username":"hehe","password":"123","age":"30"}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        //data服务器端响应的json数据进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <button id="btn">发送ajax请求</button>
</body>
</html>
