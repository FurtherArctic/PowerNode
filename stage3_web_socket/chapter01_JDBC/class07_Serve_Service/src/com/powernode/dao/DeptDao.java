package com.powernode.dao;

import com.powernode.entity.Dept;
import com.powernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjunchen
 * 基于流程的封装Dept表操作
 * insert与update方法的参数个数随着字段个数增加而无限增加，开发负担加重，使用难度增加
 * 因此可以使用 Entity 类来解决此问题
 */
public class DeptDao {
    public PreparedStatement ps;


    /**
     * 插入语句的封装
     *
     * @param dept 部门信息
     * @return int
     * @throws ClassNotFoundException 异常
     * @throws SQLException           异常
     */
    public int insertDept(Dept dept) throws Exception {
        String sql = "INSERT INTO DEPT values (?,?,?)";
        int result;
        try {
            ps = JdbcUtil.getPreparedStatement(sql);
            ps.setInt(1, dept.getDeptNo());
            ps.setString(2, dept.getdName());
            ps.setString(3, dept.getLoc());
            result = ps.executeUpdate();
        } finally {
            JdbcUtil.close();
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
            ps = JdbcUtil.getPreparedStatement(sql);
            ps.setInt(1, deptNo);
            result = ps.executeUpdate();
        } finally {
            JdbcUtil.close();
        }
        return result;
    }

    /**
     * 更新语句的封装
     *
     * @param dept 部门信息
     * @return int
     * @throws Exception 异常
     */
    public int updateDao(Dept dept) throws Exception {
        String sql = "update  DEPT set DNAME=?,LOC=? where DEPTNO=?";
        int result;
        try {

            ps = JdbcUtil.getPreparedStatement(sql);
            ps.setString(1, dept.getdName());
            ps.setString(2, dept.getLoc());
            ps.setInt(3, dept.getDeptNo());
            result = ps.executeUpdate();
        } finally {
            JdbcUtil.close();
        }
        return result;
    }

    /**
     * 查询全部数据
     *
     * @return dept 集合
     * @throws Exception 异常
     */
    public List<Dept> findAll() throws Exception {
        ResultSet rs = null;
        List<Dept> deptList = new ArrayList<Dept>();
        String sql = "select * from DEPT";

        try {
            ps = JdbcUtil.getPreparedStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int deptNo = rs.getInt("deptNo");
                String deptName = rs.getString("dName");
                String loc = rs.getString("loc");
                Dept dept = new Dept(deptNo, deptName, loc);
                deptList.add(dept);
            }
        } finally {
            JdbcUtil.close(rs);
        }
        return deptList;
    }
}
