<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/22
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.qi.ShuJuKu"%>
<%@ page import="java.sql.Connection" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<%
    try {
        Connection connection = ShuJuKu.fanHui();

    } catch (Exception e) {
        e.printStackTrace();
    }

%>

</body>
</html>
