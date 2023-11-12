package com.powernode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wangjunchen
 * 基于流程的封装Dept表
 */
public class DeptDao {
    public static String username = "root";
    public static String password = "123456";
    public static String url = "jdbc:mysql://192.168.0.100:3306/power_node?serverTimezone=UTC";

    public Connection conn;
    public PreparedStatement ps;

    /**
     * 插入语句的封装
     *
     * @param deptNo   部门编号
     * @param deptName 部门名称
     * @param loc      部门地址
     * @return int
     * @throws ClassNotFoundException 异常
     * @throws SQLException           异常
     */
    public int insertDept(int deptNo, String deptName, String loc) throws Exception {

        String sql = "INSERT INTO DEPT values (?,?,?)";
        int result;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptNo);
            ps.setString(2, deptName);
            ps.setString(3, loc);
            result = ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    /**
     * 删除语句的封装
     *
     * @param deptNo 部门编号
     * @return int
     * @throws Exception 异常
     */
    public int deleteDao(int deptNo) throws Exception {

        String sql = "delete from DEPT where DEPTNO=?";
        int result;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptNo);
            result = ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }


        return result;
    }

    /**
     * 更新语句的封装
     *
     * @param deptNo   部门编号
     * @param deptName 部门名称
     * @param loc      部门地址
     * @return int
     * @throws Exception 异常
     */
    public int updateDao(int deptNo, String deptName, String loc) throws Exception {

        String sql = "update  DEPT set DNAME=?,LOC=? where DEPTNO=?";
        int result;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptName);
            ps.setString(2, loc);
            ps.setInt(3, deptNo);
            result = ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
