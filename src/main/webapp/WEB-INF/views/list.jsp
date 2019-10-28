<%--
  Created by IntelliJ IDEA.
  User: upc
  Date: 2019/7/17
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
书籍列表:
<br>

<table>
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>数量</th>
    </tr>
    <tbody>
    <c:forEach items="${book}" var="books" >
        <tr>
            <td>${books.bookid}</td>
            <td>${books.name}</td>
            <td>${books.cnt}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>