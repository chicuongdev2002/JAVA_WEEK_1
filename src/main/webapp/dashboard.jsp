<%@ page import="vn.edu.iuh.fit.entities.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Win 11
  Date: 9/15/2023
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .btn {
            padding: 5px 10px;
            background-color: #008CBA;
            color: white;
            border: none;
            cursor: pointer;
            text-decoration: none;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-primary {
            background-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-danger {
            background-color: #dc3545;
        }

        .btn-danger:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<!-- Menu -->
<ul class="nav">
    <li><a href="#">Log</a></li>
    <li style="float:right"><button class="logout-button" onclick="logout()">Đăng xuất</button></li>
</ul>

<!-- Nội dung trang web -->
<div style="padding: 20px;">
    <h1>Xin chào, <%= session.getAttribute("username") %>!</h1>
</div>

<!-- Nội dung trang web -->
<div style="padding: 20px;">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>UserID</th>
            <th>FullName</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Role</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Account> listA = (List<Account>) session.getAttribute("account");
            if (listA != null) {
                // Hiển thị danh sách tài khoản
                for (Account a : listA) {
                     String accountID=a.getAccountId();
                    String roles= (String) session.getAttribute("roles"+accountID);
        %>
        <!-- Hiển thị thông tin tài khoản tại đây -->
        <tr>
            <td><%=a.getAccountId()%></td>
            <td><%=a.getFullName()%></td>
            <td><%=a.getEmail()%></td>
            <td><%=a.getPassword()%></td>
            <td><%=a.getPhone()%></td>
            <td><%=roles%></td>
            <td><%=a.getStatus()%></td>
            <td><a class="btn btn-primary btn-sm" href="login-control?action=AddOrEdit">Edit</a>
               <a class="btn btn-danger btn-sm" href="login-control?action=AddOrEdit">Del</a></td>
        </tr>
        <%
            }
        } else {
            // Biến "account" không tồn tại trong session, có thể chưa đăng nhập
        %>
        <p>Bạn chưa đăng nhập.</p>
        <%
            }
        %>
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