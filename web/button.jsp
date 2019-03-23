<%--
  Created by IntelliJ IDEA.
  User: Domas
  Date: 2019-03-12
  Time: 02:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/oy" method="get">

<div>
    <input type="text" width="50px" title="name" value="name" name="name">
    <input type="text" width="50px" title="address"value ="address"name="address">
    <input type="text" width="50px" title="Id"value ="id" name="Id">
</div>
    <input type="submit"  value="add" name="add">
    <input type="submit"  value="update" name="update">
    <input type="submit"  value="delete" name="delete">
</form>





</body>
</html>
