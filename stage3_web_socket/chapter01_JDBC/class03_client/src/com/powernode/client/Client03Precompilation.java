package com.powernode.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author wangjunchen
 * 带有预编译功能的客户端
 * 预编译SQL命令格式：
 * 允许开发人员在书写sql语句时，可以使用占位符(?)表示将来需要由客户提供数据
 * delete from dept where deptno=?
 * insert into dept (deptno,dname,loc) values(?,?,?)
 * <p>
 * 由PreparedStatement负责将用户提供数据填写到占位符
 * insert into dept (deptno,dname,loc) values(?,?,?)
 * ps.setInt(1,100)
 * ps.setString(2,"abc")
 * 无论字段是何种数据类型，ps.setString(位置,“值”)
 */
public class Client03Precompilation {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int result;
        String deptNo, deptName, location;
        String sql = "update dept set dname=?,loc=? where DEPTNO=?";
        PreparedStatement ps;
        Connection conn;
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://192.168.0.107:3306/power_node?serverTimezone=UTC";
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the deptNo:");
        deptNo = sc.next();
        System.out.println("please enter the deptName:");
        deptName = sc.next();
        System.out.println("please enter the location:");
        location = sc.next();

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        ps = conn.prepareStatement(sql);
        ps.setString(1, deptName);
        ps.setString(2, location);
        ps.setString(3, deptNo);
        result = ps.executeUpdate();

        ps.close();
        conn.close();
        System.out.println("this time update " + result + " data.");

    }
}
