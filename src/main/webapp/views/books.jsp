<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 17/04/2024
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <title>List Book</title>
</head>
<body>
<h2 class="listBook">List Book</h2>
<table border="1">
    <thead>
    <tr>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>Price</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.price}</td>
            <td>${book.status?"Còn bán":"Hết sách"}</td>
            <td>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/bookController/initCreate">Create New Book</a>
</body>
</html>
