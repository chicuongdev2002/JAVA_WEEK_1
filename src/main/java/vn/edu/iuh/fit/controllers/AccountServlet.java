package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet",value = "/account-servlet")

public class AccountServlet extends HttpServlet {
    AccountRepository AccRe=new AccountRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        //Load thông tin account
        List<Account> accounts=AccRe.getAllAccount();
        req.setAttribute("accounts",accounts);
        req.getRequestDispatcher("/displayaccount.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
