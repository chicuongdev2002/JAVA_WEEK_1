package vn.edu.iuh.fit.db;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.List;

public class test {
    public static void main(String[] args) {
//        //Test Connect
//        ConnectDB c=new ConnectDB();
//        System.out.println("Connect thanh cong");
       //Test account
       AccountRepository a=new AccountRepository();
        List<Account> listA=a.getAllAccount();
        listA.forEach(p-> System.out.println(p));
    }
}
