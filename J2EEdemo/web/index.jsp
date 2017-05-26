<%@ page import="com.sun.org.apache.bcel.internal.generic.Select" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/22
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <%
    int i = 0;
    out.print("<a href="+"Select.jsp>"+"查看信息"+"</a>"+"</br>");
    out.print("<a href="+"Delect.jsp>"+"删除信息</a>"+"</br>");
    out.print("<a href="+"add.jsp?"+(i++)+">"+"添加信息</a>"+"</br>");
    out.print("<a href="+"update.jsp>"+"修改信息</a>"+"</br>");
  %>

  <a></a>
  </body>
</html>