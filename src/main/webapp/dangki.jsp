<%--
  Created by IntelliJ IDEA.
  User: Win 11
  Date: 9/15/2023
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap/dist/js/bootstrap.min.js"></script>

</head>
<style>
    body {
        background-color: #f4f4f4;
    }

    .wrapper {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background: #fff;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
        margin-top: 100px;
    }

    .form-label {
        font-weight: bold;
    }
</style>

<body>
<div class="wrapper">
    <h2 class="text-center">Đăng ký tài khoản</h2>
    <form  action="LoginControl" id="registrationForm" onsubmit="return validateForm()" method="post">
        <div class="mb-3">
            <label for="accountId" class="form-label">Account ID:</label>
            <input type="text" id="accountId" name="accountId" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="fullName" class="form-label">Họ và tên:</label>
            <input type="text" id="fullName" name="username" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu:</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" id="email" name="email" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Số điện thoại:</label>
            <input type="tel" id="phone" name="phone" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="status" class="form-label">Trạng thái:</label>
            <select id="status" name="status" class="form-select">
                <option value="0">Không hoạt động</option>
                <option value="1">Hoạt động</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
        <button class="btn btn-primary" onclick="window.location.href='index.jsp'">Quay lại</button>
    </form>

</div>
<script>
        function validateForm() {
        // Lấy giá trị từ các trường nhập liệu
        var accountId = document.getElementById("accountId").value;
        var fullName = document.getElementById("fullName").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;
        var phone = document.getElementById("phone").value;
        var status = document.getElementById("status").value;

        // Kiểm tra các điều kiện validate
        if (accountId === "") {
        alert("Vui lòng nhập Tên đăng nhập");
        return false;
    }

        if (fullName === "") {
        alert("Vui lòng nhập Họ và tên");
        return false;
    }

        if (password === "") {
        alert("Vui lòng nhập Mật khẩu");
        return false;
    }

        if (email === "") {
        alert("Vui lòng nhập Email");
        return false;
    }

        // Kiểm tra định dạng Email sử dụng regex
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        if (!emailPattern.test(email)) {
        alert("Email không hợp lệ");
        return false;
    }

        if (phone === "") {
        alert("Vui lòng nhập Số điện thoại");
        return false;
    }

        // Kiểm tra status có phải là số
        if (isNaN(status)) {
        alert("Trạng thái phải là số");
        return false;
    }
        // Nếu tất cả kiểm tra đều đã qua, cho phép gửi biểu mẫu
        return true;
    }
</script>
</body>
</html>
