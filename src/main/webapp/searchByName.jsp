<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/12/2023
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product List</title>
</head>
<body>
<h1>Search Name</h1>
<p>
  <a href="/product">Back to product list</a>
</p>
<table border="1">

  <tr>
    <td>Id</td>
    <td>Name Product</td>
    <td>Price Product</td>
    <td>Description Product</td>
    <td>Company</td>
  </tr>
  <tbody>
  <c:forEach items="${product}" var="product">
    <tr>
      <td>${product.getId()}</td>
      <td>${product.getNameProduct()}</td>
      <td>${product.getPriceProduct()}</td>
      <td>${product.getDescription()}</td>
      <td>${product.getCompany()}</td>

    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
