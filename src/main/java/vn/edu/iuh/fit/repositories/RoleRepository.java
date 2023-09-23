package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.ConnectDB;
import vn.edu.iuh.fit.entities.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleRepository {

    Connection con;


    public  RoleRepository()
    {
        con= ConnectDB.getInstance().getConnection();
    }

    public ArrayList<Role> getRoles() {
        ArrayList<Role> Roles = new ArrayList<Role>();
        try {
            String sql = "select * from Role";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Roles.add(new Role(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Roles;
    }
    //Lấy tên Role dựa vào RoleID
    public String getRoleName(String RoleID) {
        String RoleName = "";
        try {
            String sql = "select role_name from role where role_id='" + RoleID + "'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                RoleName = rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return RoleName;
    }
    }