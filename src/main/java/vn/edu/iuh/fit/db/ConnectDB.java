package vn.edu.iuh.fit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance;
    private Connection connect;
    private ConnectDB() {
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Load driver successfully");
            connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb","root","sapassword");
            System.out.println("Connection valid: " + connect.isValid(5));
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
    }
}
public  static ConnectDB getInstance(){
    if(instance == null){
        instance = new ConnectDB();
    }
    return instance;
}
public Connection getConnection(){
    return connect;
}
}
