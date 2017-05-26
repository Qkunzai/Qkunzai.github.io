<%@ page import="java.sql.Connection" %>
<%@ page import="com.qi.ShuJuKu"%>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/23
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
    <%
        Connection connection = ShuJuKu.fanHui();
        String sql = "SELECT * FROM zhucebiao";
        Statement statement = connection.createStatement();
        ResultSet resu = statement.executeQuery(sql);
        out.println("------- 记录表 -------"+"</br>");
        out.println("----编号\t"+"姓名\t"+"年龄\t"+"性别----"+" </br>");
        while(resu.next()){
            int id = resu.getInt("id");
            String name = resu.getString("name");
            int age = resu.getInt("age");
            String sex = resu.getString("sex");
            out.println(id+"\t"+name+"\t"+age+"\t"+sex+" </br>");
        }
    %>
</body>
</html>
