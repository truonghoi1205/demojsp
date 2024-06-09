<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/7/2024
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <div class="d-flex justify-content-between">
        <h3>Trang sách đã được mượn</h3>
        <a href="/books/list" class="btn btn-primary">Trở về trang sách</a>
    </div>
    <div>
        <table class="table">
            <tr>
                <th>Mã mượn sách</th>
                <th>Tên sách</th>
                <th>Tác giả</th>
                <th>Tên học sinh</th>
                <th>Lớp</th>
                <th>Ngày mượn</th>
                <th>Ngày trả</th>
                <th></th>
            </tr>
            <c:forEach var="borrow" items="${borrows}">
                <tr>
                    <td>${borrow.code}</td>
                    <td>${borrow.book.name}</td>
                    <td>${borrow.book.author}</td>
                    <td>${borrow.student.name}</td>
                    <td>${borrow.student.classroom}</td>
                    <td>${borrow.borrowDay}</td>
                    <td>${borrow.returnDay}</td>
                    <form action="/borrows/delete" method="post">
                        <td>
                            <input type="hidden" name="id" value="${borrow.id}">
                            <input type="hidden" name="bookId" value="${borrow.book.bookId}">
                            <button type="submit" class="btn btn-primary">Trả sách</button>
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
