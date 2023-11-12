package com.powernode.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author wangjunchen
 * 具有交互功能的客户端
 */
public class Client02Mutual {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int result;
        String deptNo, deptName, location, sql;
        PreparedStatement ps;
        Connection conn;
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://192.168.0.100:3306/power_node?serverTimezone=UTC";
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the deptNo:");
        deptNo = sc.next();
        System.out.println("please enter the deptName:");
        deptName = sc.next();
        System.out.println("please enter the location:");
        location = sc.next();

        sql = "update DEPT set dName='" + deptName + "',loc='" + location + "' where deptNo='" + deptNo + "'";
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        ps = conn.prepareCall(sql);
        result = ps.executeUpdate();

        ps.close();
        conn.close();
        System.out.println("this time update " + result + " data.");

    }
}
