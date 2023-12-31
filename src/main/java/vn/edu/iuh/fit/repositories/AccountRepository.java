package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.ConnectDB;
import vn.edu.iuh.fit.entities.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountRepository {
    Connection connection;
    public AccountRepository() {
        connection = ConnectDB.getInstance().getConnection();
    }
   //Thêm account
    public boolean createAccount(Account account) {
        try {
            String sql = "INSERT INTO account (account_id,full_name,password,email,phone,status) VALUES (?,?,?,?,?)";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.setString(1, account.getAccountId());
       statement.setString(2, account.getFullName());
        statement.setString(3, account.getPassword());
        statement.setString(4, account.getEmail());
        statement.setString(5, account.getPhone());
        statement.setInt(6, account.getStatus());
        if(statement.executeUpdate()>0);
        {
            return true;
        }
        }catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }
   //Lấy danh sách account
    public ArrayList<Account> getAllAccount(){
        ArrayList<Account> list = new ArrayList<Account>();
        try {
            String sql = "SELECT * FROM account";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Account account = new Account();
                account.setAccountId(rs.getString("account_id"));
                account.setFullName(rs.getString("full_name"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));
                account.setStatus(rs.getInt("status"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//Kiểm tra user
public Account checkAccount(String userName,String password)
{
    Account account = null;
    try {
        String sql = "SELECT * FROM account WHERE account_id =? AND password =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();
        if(rs.next())
        {
            account=new Account(((ResultSet) rs).getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return account;
}
//Lấy account theo id
public Account getAccountById(String accountId) {
    String query = "SELECT * FROM accounts WHERE account_id = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, accountId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Account account = new Account();
            account.setAccountId(resultSet.getString("account_id"));
            account.setFullName(resultSet.getString("full_name"));
            // Thêm các trường khác vào đây
            return account;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}
