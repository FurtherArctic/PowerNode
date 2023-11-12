package com.powernode.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
    private static final String username = "root";
    private static final String password = "123456";
    private static final String url = "jdbc:mysql://192.168.0.100:3306/power_node?serverTimezone=UTC";

    private static Connection conn;
    private static PreparedStatement ps;

    /**
     * 封装获取Connection对象方法
     *
     * @return Connection
     * @throws Exception 异常
     */
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * 封装获取PreparedStatement对象
     *
     * @param sql sql语句
     * @return PreparedStatement对象
     * @throws Exception 异常
     */
    public static PreparedStatement getPreparedStatement(String sql) throws Exception {
        ps = getConnection().prepareStatement(sql);
        return ps;
    }

    /**
     * 开闭原则,关闭PreparedStatement和Connection通道
     * 关闭原则：如果一个方法在项目中已经被使用了，则关闭方法修改通道
     * 开原则：永远打开一个类文件的扩展通道
     *
     * @throws Exception 异常
     */
    public static void close() throws Exception {
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * 对于DQL语句,还需要关闭ResultSet通道
     *
     * @param rs ResultSet对象
     * @throws Exception 异常
     */
    public static void close(ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
        close();
    }
}
