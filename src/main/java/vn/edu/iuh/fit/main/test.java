package vn.edu.iuh.fit.main;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.sql.SQLException;
public class test {
    public static void main(String[] args) throws SQLException {


        String username = "Met";
        String password = "123";

        AccountRepository AccRepo = new AccountRepository();
        Account acc = AccRepo.checkAccount(username, password);
        if (acc == null) {
            System.out.println("Sai username hoac password!");
        } else {
            System.out.println(acc.toString());

        }
        System.out.println();
    }
}
