package vn.edu.iuh.fit.controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.entities.Account;
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
  try {
      String username =req.getParameter("username");
      String password =req.getParameter("password");
      System.out.print( username+password);
      Account a=AccRe.checkAccount(username,password);
      if(a==null)
      {
          req.setAttribute("messenger","Thông tin không chính xác");
          req.getRequestDispatcher("index.jsp").forward(req,resp);
      }else
      {
          // Lưu tên người dùng vào session
          HttpSession session = req.getSession();
          session.setAttribute("username", a.getFullName());
         resp.sendRedirect("dashboard.jsp");
      }
  }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
