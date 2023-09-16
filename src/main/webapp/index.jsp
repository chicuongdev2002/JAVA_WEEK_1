<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css">
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
  </style>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(document).ready(function() {
      $("#dangki").click(function() {
        // Chuyển hướng đến trang "register.jsp"
        window.location.href = "register.jsp";
      });
    });
  </script>

</head>
<body>
<div class="wrapper">
  <h2 class="text-center">Đăng nhập</h2>
  <form action="login-control" method="post">
    <p class="text-danger">${messenger}</p>
    <div class="mb-3">
      <label for="username" class="form-label">Tên đăng nhập</label>
      <input name="username" type="text" class="form-control" id="username" placeholder="Nhập tên đăng nhập">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Mật khẩu</label>
      <input name="password" type="password" class="form-control" id="password" placeholder="Nhập mật khẩu">
    </div>
    <button name="" type="submit" class="btn btn-primary">Đăng nhập</button>
    <input type="hidden" name="action" value="login">
    <h5>Bạn chưa có tài khoản?</h5>
    <a href="register.jsp" class="btn-btn-link">Đăng kí</a>
    <input type="hidden" name="action" value="log">

  </form>
</div>
</body>
</html>
