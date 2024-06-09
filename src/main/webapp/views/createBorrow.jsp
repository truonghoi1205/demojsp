<%@ page import="java.sql.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/7/2024
  Time: 2:40 PM
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
<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-12 col-lg-6">
            <div class="shadow-sm rounded p-3 bg-white">
                <h4 class="mb-3">Mượn sách</h4>
                <form method="post" action="/borrows/create" id="borrow-form">
                    <div class="mb-3 form-floating">
                        <input type="text" class="form-control" id="borrowCode" placeholder="mã mượn sách" name="borrowCode" pattern="^MS-\d{4}$" required>
                        <label for="borrowCode" class="form-label">Mã mượn sách (VD: MS0000)</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="hidden" name="bookId" value="${book.bookId}">
                        <input type="text" disabled class="form-control" id="nameBook" placeholder="Tên sách" name="nameBook" value="${book.name}">
                        <label for="nameBook" class="form-label">Tên sách</label>
                    </div>

                    <select class="form-select form-select-lg mb-3" name="studentId">
                        <c:forEach var="student" items="${students}">
                            <option value="${student.studentId}">${student.name}</option>
                        </c:forEach>
                    </select>

                    <%Date date = new Date(System.currentTimeMillis());%>
                    <div class="mb-3 form-floating">
                        <input type="date" disabled class="form-control" id="borrowDate" value="<%out.print(date);%>" name="borrowDate">
                        <label for="borrow_day" class="form-label">ngày mượn sách</label>
                    </div>
                    <div class="mb-3 form-floating">
                        <input type="date" class="form-control" id="returnDate" placeholder="ngày trả sách" min="<%out.print(date);%>" value="<%out.print(date);%>"
                               name="returnDate">
                        <label for="return_day" class="form-label">ngày trả sách</label>
                    </div>
                    <div class="d-flex justify-content-between row">
                        <div class="d-grid gap-2 mt-5 col-4">
                            <button type="submit" class="btn btn-primary btn-sm">Mượn</button>
                        </div>
                        <div class="d-grid gap-2 mt-5 col-4">
                            <a href="/books/list" class="btn btn-danger btn-sm">Hủy</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
