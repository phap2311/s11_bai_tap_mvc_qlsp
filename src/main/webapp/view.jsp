<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/1/2024
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông tin chi tiết</h2>
<p>
    <a href="/product">Back to product list</a>
</p>
<table border="1px">
    <tr><td>${productView.getId()}</td></tr>
    <tr><td>${productView.getNameProduct()}</td></tr>
    <tr><td>${productView.getPriceProduct()}</td></tr>
    <tr><td>${productView.getDescription()}</td></tr>
    <tr><td>${productView.getCompany()}</td></tr>


</table>
</body>
</html>
