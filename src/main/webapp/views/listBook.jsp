<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/7/2024
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between">
        <h2>List book</h2>
        <a href="/borrows/list" class="btn btn-primary">Qua trang sách đã mượn</a>
    </div>
    <div>
        <table class="table text-center">
            <tr>
                <th>Mã sách</th>
                <th>Tên sách</th>
                <th>Tác giả</th>
                <th>Mô tả</th>
                <th>Số lượng</th>
                <th></th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.code}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td>${book.quantity}</td>
                    <td>
                        <a href="/borrows/create?id=${book.bookId}" class="btn btn-primary btn-sm fst-normal" style="--bs-btn-padding-y: .25rem; --bs-btn-padding-x: .5rem; --bs-btn-font-size: .75rem;">Mượn sách</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
