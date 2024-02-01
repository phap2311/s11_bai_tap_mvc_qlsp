<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/1/2024
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <leged>
        Thông tin sản phẩm
    </leged>
<table>
<tr> <td><input type="text" name="id"  value="${productUp.getId()}" ></td></tr>
<tr> <td><input type="text" name="name_product" value="${productUp.getNameProduct()}" ></td></tr>
<tr> <td><input type="text" name="price_product" value="${productUp.getPriceProduct()}" ></td></tr>
<tr> <td><input type="text" name="description_product" value="${productUp.getDescription()}" ></td></tr>
<tr> <td><input type="text" name="company_product" value="${productUp.getCompany()}" ></td></tr>
    <tr><td>
        <button>Update</button>
    </td></tr>
</table>
</form>
</body>
</html>
