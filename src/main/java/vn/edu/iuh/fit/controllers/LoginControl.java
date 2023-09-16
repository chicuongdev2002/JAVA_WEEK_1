package vn.edu.iuh.fit.controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GantAccessRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

import java.io.IOException;

@WebServlet(name="LoginControl",value = "/login-control")
public class LoginControl  extends  HttpServlet{

    private AccountRepository AccRe = new AccountRepository();
    private RoleRepository RollRe = new RoleRepository();
    private GantAccessRepository GrantRe = new GantAccessRepository();
    private Account a=new Account();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test");
        String action=req.getParameter("action");
  try {
      if(action.equalsIgnoreCase("login")) {
          String username = req.getParameter("username");
          String password = req.getParameter("password");
          System.out.print(username + password);
          Account a = AccRe.checkAccount(username, password);
          if (a == null) {
              req.setAttribute("messenger", "Thông tin không chính xác");
              req.getRequestDispatcher("index.jsp").forward(req, resp);
          } else {
              // Kiểm tra quyền của người dùng
              String role = GrantRe.getRoleByAccId(a.getAccountId());
              if (role.equals("admin")) {
                  // Lưu tên người dùng vào session
                  HttpSession session = req.getSession();
                  session.setAttribute("username", a.getFullName());
                  resp.sendRedirect("dashboard.jsp");
              } else {
                  HttpSession session = req.getSession();
                  session.setAttribute("username", a.getFullName());
                  resp.sendRedirect("user.jsp");
              }
              if (action.equals("logout")) {
                  HttpSession session = req.getSession();
                  session.removeAttribute("username");
                  resp.sendRedirect("index.jsp");
                  //Đăng kí account mới
              } else if (action.equalsIgnoreCase("register")) {
                  // Lấy thông tin từ biểu mẫu đăng ký
                  String accountId = req.getParameter("accountId");
                  String fullName = req.getParameter("fullName");
                  String newpassword = req.getParameter("password");
                  String email = req.getParameter("email");
                  String phone = req.getParameter("phone");
                  String status = req.getParameter("status");

                  // Kiểm tra xem tài khoản đã tồn tại hay chưa
                  Account existingAccount = AccRe.getAccountById(accountId);
                  if (existingAccount != null) {
                      req.setAttribute("messageRegis", "Tài khoản đã tồn tại");
                      req.getRequestDispatcher("register.jsp").forward(req, resp);
                      return;
                  }

                  // Tạo một tài khoản mới
                  Account newAccount = new Account();
                  newAccount.setAccountId(accountId);
                  newAccount.setFullName(fullName);
                  newAccount.setPassword(newpassword);
                  newAccount.setEmail(email);
                  newAccount.setPhone(phone);
                  newAccount.setStatus(Integer.parseInt(status));

                  // Lưu tài khoản mới vào cơ sở dữ liệu
                  boolean registrationSuccess = AccRe.createAccount(newAccount);

                  if (registrationSuccess) {
                      // Đăng ký thành công, chuyển hướng đến trang thành công
                      resp.sendRedirect("index.jsp");
                  } else {
                      // Đăng ký thất bại, hiển thị thông báo lỗi
                      req.setAttribute("messageRegis", "Đăng ký thất bại");
                      req.getRequestDispatcher("DangKi.jsp").forward(req, resp);
                  }
              }
          }
      }
  }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
