<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 19/04/2024
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/bookController/update" method="post">
  <label for="bookId">Book Id</label>
  <input type="text" name="bookId" id="bookId" readonly value="${bookUpdate.bookId}"/><br>
  <label for="bookName">Book Name</label>
  <input type="text" name="bookName" id="bookName" value="${bookUpdate.bookName}"/><br>
  <label for="price">Price</label>
  <input type="number" name="price" id="price" value="${bookUpdate.price}"/><br>
  <label for="active">Status</label>
  <input type="radio" name="status" id="active" value="true" ${bookUpdate.status?'checked':''}/><label for="active">Còn hàng</label>
  <input type="radio" name="status" id="inActive" value="false" ${bookUpdate.status?'':'checked'}/><label for="inActive">Hết sách</label><br>
  <input type="submit" value="Update"/>
</form>
</body>
</html>
