package com.powernode.client;

import java.sql.*;

/**
 * @author wangjunchen
 * 推送DQL语句的客户端
 */
public class Client04PushDQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ResultSet resultSet;
        String sql = "select * from DEPT";
        PreparedStatement ps;
        Connection conn;
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://192.168.0.100:3306/power_node?serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        ps = conn.prepareStatement(sql);
        resultSet = ps.executeQuery();
        while (resultSet.next()) {
            String deptNo = resultSet.getString("deptNo");
            String deptName = resultSet.getString("dName");
            String location = resultSet.getString("Loc");
            System.out.println("deptNo: " + deptNo + ", deptName:" + deptName + ", location:" + location);
        }
        resultSet.close();
        ps.close();
        conn.close();


    }
}
