<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 17/04/2024
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Book</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/bookController/create" method="post">
    <label for="bookName">Book Name</label>
    <input type="text" name="bookName" id="bookName"/><br>
    <label for="price">Price</label>
    <input type="number" name="price" id="price"/><br>
    <label for="active">Status</label>
    <input type="radio" name="status" id="active" value="true"/><label for="active">Còn hàng</label>
    <input type="radio" name="status" id="inActive" value="false"/><label for="inActive">Hết sách</label><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
