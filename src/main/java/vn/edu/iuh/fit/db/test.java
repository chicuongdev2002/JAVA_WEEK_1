package vn.edu.iuh.fit.db;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

public class test {
    public static void main(String[] args) {

        String username="Met";
        String password="123";

        AccountRepository AccRepo = new AccountRepository();
        Account acc = AccRepo.checkAccount(username,password);
        if(acc ==null)
        {
            System.out.println("Sai username hoặc password");
        }else {
            System.out.println(acc.toString());
        }
    }
}
