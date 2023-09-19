<%--
  Created by IntelliJ IDEA.
  User: Win 11
  Date: 9/19/2023
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:useBean id="da" class="vn.edu.iuh.fit.repositories.AccountRepository" scope="request"></jsp:useBean>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chính</title>
    <!-- Thêm CSS cho menu -->
    <style>
        ul.nav {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        ul.nav li {
            float: left;
        }

        ul.nav li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.nav li a:hover {
            background-color: #ddd;
            color: black;
        }

        .logout-button {
            background-color: red;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<!-- Menu -->
<ul class="nav">
    <li><a href="dashboard.jsp">Home</a></li>
    <li><a href="">Account</a></li>
    <li><a href="#">Role</a></li>
    <li><a href="#">Log</a></li>
    <li style="float:right"><button class="logout-button" onclick="logout()">Đăng xuất</button></li>
</ul>

<!-- Nội dung trang web -->
<div style="padding: 20px;">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>UserID</th>
            <th>FullName</th>
            <th>Password</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${da.allAccount}">
            <tr>
                <td>${user.accountId}</td>
                <td>${user.fullName}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script>
    function logout() {
        // Thực hiện các thao tác đăng xuất tài khoản ở đây (ví dụ: xóa phiên đăng nhập)
        alert("Đã đăng xuất!");
        // Chuyển hướng đến trang đăng nhập hoặc trang chính của bạn
        window.location.href = "index.jsp"; // Thay thế bằng URL trang đăng nhập hoặc trang chính
    }
</script>
</body>
</html>
