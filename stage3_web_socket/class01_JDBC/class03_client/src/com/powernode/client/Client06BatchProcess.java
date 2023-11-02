package com.powernode.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author wangjunchen
 * 批处理sql语句
 */
public class Client06BatchProcess {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sql = "insert into dept values (?,?,?)";
        PreparedStatement ps;
        Connection conn;
        int deptNum;
        String deptNo, deptName, deptLocation;
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://192.168.0.107:3306/power_node?serverTimezone=UTC";

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要添加的部门个数：");
        deptNum = scanner.nextInt();

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        ps = conn.prepareStatement(sql);
        for (int i = 0; i < deptNum; i++) {
            System.out.println("请输入第" + (i + 1) + "个新部门编号");
            deptNo = scanner.next();
            System.out.println("请输入第" + (i + 1) + "个新部门名称");
            deptName = scanner.next();
            System.out.println("请输入第" + (i + 1) + "个新部门位置");
            deptLocation = scanner.next();

            ps.setString(1, deptNo);
            ps.setString(2, deptName);
            ps.setString(3, deptLocation);

            //将每一条sql语句添加到弹夹
            ps.addBatch();
        }

        try {
            //推送全部的sql语句
            ps.executeBatch();
            conn.commit();
            System.out.println("添加成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作失误，回滚处理");
            conn.rollback();
        } finally {
            ps.close();
            conn.close();
        }
    }
}
