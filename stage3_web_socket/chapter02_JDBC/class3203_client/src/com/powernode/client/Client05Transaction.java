package com.powernode.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wangjunchen
 * 带有事务管理功能的客户端
 */
public class Client05Transaction {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //解散某个部门
        String sql1 = "delete from EMP where DEPTNO=?";
        String sql2 = "delete from DEPT where DEPTNO=?";

        PreparedStatement ps1, ps2;
        Connection conn;
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://192.168.0.100:3306/power_node?serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        /*
         * 默认情况下，事务提交由数据库服务器管理，此时autoCommit的值为true；
         * 通过setAutoCommit方法将autoCommit的值设置为false，
         * 触发con向通道尽头发送start transaction，则表示事务管理由Connection对象来接管
         */
        conn.setAutoCommit(false);
        ps1 = conn.prepareStatement(sql1);
        ps2 = conn.prepareStatement(sql2);

        ps1.setString(1, "1");
        ps2.setString(1, "q");

        try {
            int result1 = ps1.executeUpdate();
            int result2 = ps2.executeUpdate();
            //所有的语句都没有异常，则提交commit
            conn.commit();
            System.out.println("本次操作执行了" + (result1 + result2) + "行数据");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作事务，回滚数据！！！");
            //出现异常，回滚
            conn.rollback();
        }
        ps2.close();
        ps1.close();
        conn.close();
    }
}
