package com.powernode.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wangjunchen
 * 最简单的客户端
 */
public class Client01Simple {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int result;
        String sql = "insert into DEPT values(110,'培训部门','上海')";
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://192.168.0.100:3306/power_node?serverTimezone=UTC";
        Connection conn;
        PreparedStatement ps;
        //JDBC步骤
        //1. 创建一个Driver对象并交给DriverManager管理；
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. DriverManager引导Driver建立通道，创建好通道交给Connection管理；
        conn = DriverManager.getConnection(url, user, password);
        //3. Connection负责提供一个PreparedStatement对象；
        ps = conn.prepareStatement(sql);
        //4. PreparedStatement对象负责推送SQL语句并返回该语句的执行结果；
        result = ps.executeUpdate();
        //5. 通信结束后，销毁本次通信过程中的所有人员（对象）。
        ps.close();
        conn.close();
        System.out.println("本次帮助你添加" + result + "个部门");
    }
}
