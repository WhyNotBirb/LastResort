<%--
  Created by IntelliJ IDEA.
  User: Domas
  Date: 2019-03-03
  Time: 08:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <div><img src="${name}" title="${alttext}" alt="${title}"></div>

  <form action="${pageContext.request.contextPath}/yo" method="get">
    <input type="submit" name="button1" value="Button 1" />
    <input type="submit" name="button2" value="Button 2" />
  </form>

  </body>
</html>
