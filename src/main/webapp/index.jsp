<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/6/10
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IP SEARCH</title>
</head>
<body>
<h1>IP SEARCH</h1>
<form action="search" method="post">
<input type="text" name="content" placeholder="在此输入ip地址">
<input type="submit" name="查询">
</form>
<p>
    <%
        String message = (String) request.getAttribute("message");
           out.print("地址：");
        if (message != null) {
            out.print(message);
        }
    %>
</p>
</body>
</html>
