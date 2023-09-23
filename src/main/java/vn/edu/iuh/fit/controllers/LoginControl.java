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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="LoginControl",value = "/login-control")
public class LoginControl  extends  HttpServlet{
    private AccountRepository AccRe = new AccountRepository();
    private RoleRepository RoleRe = new RoleRepository();
    private GantAccessRepository GrantRe = new GantAccessRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Tải danh sách tài khoản và hiển thị trang dashboard
        loadAccountListAndForwardToDashboard(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "login":
                    processLogin(req, resp);
                    break;
                case "logout":
                    processLogout(req, resp);
                    break;
                case "register":
                    processRegistration(req, resp);
                    break;
                default:
                    // Xử lý khi action không hợp lệ
                    break;
            }
        } else {
            // Mặc định: Tải danh sách tài khoản và hiển thị trang dashboard
        }
    }

    private void processLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account a = AccRe.checkAccount(username, password);
        System.out.println(a);
        if (a == null) {
            req.setAttribute("messenger", "Thông tin không chính xác");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            String role = GrantRe.getRoleByAccId(a.getAccountId());
            System.out.println(role);
            if (role != null) {
                if (role.equals("admin")) {
                    HttpSession session = req.getSession();
                    session.setAttribute("username", a.getFullName());
                    List<Account> account = AccRe.getAllAccount();
                    for (Account ac : account) {
                        String roles = GrantRe.getRoleByAccId(ac.getAccountId());
                        System.out.println(roles);
                        session.setAttribute("roles" + ac.getAccountId(), roles);
                    }
                    session.setAttribute("account", account);
                    resp.sendRedirect("dashboard.jsp");
                } else {
                    HttpSession session = req.getSession();
                    session.setAttribute("username", a.getFullName());
                    resp.sendRedirect("user.jsp");
                }
            } else {
                // Xử lý khi không có quyền
            }
        }
    }

    private void processLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        resp.sendRedirect("index.jsp");
    }

    private void processRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý đăng ký tài khoản ở đây
        // ...
    }

    private void loadAccountListAndForwardToDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> account = AccRe.getAllAccount();
        account.forEach(p-> System.out.println(p));
        HttpSession session = req.getSession();
        session.setAttribute("account", account);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
