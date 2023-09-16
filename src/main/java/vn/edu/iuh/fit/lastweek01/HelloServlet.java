package vn.edu.iuh.fit.lastweek01;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GantAccessRepository;
import vn.edu.iuh.fit.repositories.RoleRepository;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

      private AccountRepository AccRe = new AccountRepository();
//    private RoleRepository RollRe = new RoleRepository();
//    private GantAccessRepository GrantRe = new GantAccessRepository();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("xin chao");

    }

    public void destroy() {
    }
}