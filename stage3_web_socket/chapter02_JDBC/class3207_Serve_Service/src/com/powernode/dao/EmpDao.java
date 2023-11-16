package com.powernode.dao;

import com.powernode.util.JdbcUtil;

import java.sql.PreparedStatement;

public class EmpDao {
    public PreparedStatement ps;

    public int deleteEmp(int deptNo) throws Exception {
        String sql = "DELETE FROM EMP where deptNo=?";
        int result;
        try {
            ps = JdbcUtil.getPreparedStatement(sql);
            ps.setInt(1, deptNo);
            result = ps.executeUpdate();
            System.out.println("delete successfully!!!");
        } finally {
            JdbcUtil.close();
        }
        return result;
    }
}
