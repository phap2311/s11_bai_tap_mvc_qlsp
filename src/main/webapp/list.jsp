<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/1/2024
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>

<h1>Danh sách sản phẩm</h1>
<form action="/product">
    <input type="hidden" name="action" value="searchByName">
    <input type="text" name="nameProduct">
    <button type="submit">Tìm kiếm</button>
</form>
<p>
    <a href="product?action=create">
        Create new product
    </a>
</p>

<table border="1px">
    <tr>
        <td>Số thứ tự</td>
        <td>Tên sản phẩm</td>
        <td>Giá sản phẩm</td>
        <td>Mô tả</td>
        <td>Nhà sản xuất</td>
        <td>Sửa</td>
        <td>Xóa</td>
        <td>Chi tiết sản phẩm</td>
    </tr>
    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.id}</td>
            <td>${p.nameProduct}</td>
            <td>${p.priceProduct}</td>
            <td>${p.description}</td>
            <td>${p.company}</td>
            <td><a href="product?action=edit&id=${p.getId()}">Edit</a></td>
            <td><a href="product?action=delete&id=${p.getId()}">Delete</a></td>
            <td><a href="product?action=view&id=${p.getId()}">Detail</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
