<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/8/2024
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<form action="/books/error">
    <div class="container">
        <h1 class="mt-5">Lỗi</h1>
        <div class="alert alert-danger mt-3">
            <%= request.getAttribute("errorMessage") %>
        </div>
        <a href="/books/list" class="btn btn-primary">Quay lại trang sách </a>
    </div>
</form>
</body>
</html>
