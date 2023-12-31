# Quản lý Tài khoản và Phân quyền - Bài tập thực hành Tuần 1

## Giới thiệu

Dự án này là một ứng dụng Jakarta EE đơn giản để quản lý tài khoản và phân quyền cho người dùng. Ứng dụng cho phép thực hiện các chức năng cơ bản như đăng nhập, hiển thị thông tin tài khoản, quản lý quyền truy cập và ghi log đăng nhập/đăng xuất.

## Cài đặt và Chạy ứng dụng

### Yêu cầu

- JDK (Java Development Kit 17.0.6)
- Jakarta EE Server (ví dụ: Apache Tomcat 10.1.13)
- MySQL Database (MariaDB 11.1)

### Bước 1: Thiết lập Cơ sở dữ liệu

Trước khi chạy ứng dụng, cần tạo Cơ sở dữ liệu và các bảng tương ứng. Sử dụng tệp SQL sau để tạo các bảng cần thiết trong MariaDB:

```sql
-- Tạo bảng account
CREATE TABLE account (
    account_id INT PRIMARY KEY,
    full_name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    status INT
);

-- Tạo bảng role
CREATE TABLE role (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(50),
    description VARCHAR(255),
    status INT
);

-- Tạo bảng grant_access
CREATE TABLE grant_access (
    account_id INT,
    role_id INT,
    is_grant INT,
    note VARCHAR(255)
);

-- Tạo bảng log
CREATE TABLE log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    login_time DATETIME,
    logout_time DATETIME,
    note VARCHAR(255)
);
```
### Bước 2
- Thay đổi các thông số như Driver, url,user,password tương ứng
- Class.forName("org.mariadb.jdbc.Driver");
- connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","sapassword";
### Bước 3
- Sau khi cài đặt CSDL và cấu hình kết nối, có thể triển khai ứng dụng truy cập nó thông qua trình duyệt web.
## Sơ đồ ER Diagram
![image](https://github.com/chicuongdev2002/week01_lab_NguyenChiCuong/assets/124854803/e2250713-a86e-4006-a4b3-e4ad198ab831)
## Chức năng
### Đăng nhập
![image](https://github.com/chicuongdev2002/week01_lab_NguyenChiCuong/assets/124854803/984feaba-966a-4a65-aac1-68b6bfdb7733)
### Đăng kí
![image](https://github.com/chicuongdev2002/week01_lab_NguyenChiCuong/assets/124854803/aa8e1d44-1239-4518-876f-6b39b1b5349d)
- Hiển thị thông tin tài khoản
#### Admin
![image](https://github.com/chicuongdev2002/week01_lab_NguyenChiCuong/assets/124854803/203bc311-a214-43fa-82d0-cb4b800bc9b4)
- Hiển thị quyền của các tài khoản
#### User
![image](https://github.com/chicuongdev2002/week01_lab_NguyenChiCuong/assets/124854803/cd38291f-e1a9-4698-be34-0e225223a7db)
- Cấp quyền cho một tài khoản
- Ghi log đăng nhập/đăng xuất

 


