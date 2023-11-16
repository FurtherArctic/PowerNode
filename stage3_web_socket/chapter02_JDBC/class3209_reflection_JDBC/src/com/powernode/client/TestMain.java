package com.powernode.client;

import com.powernode.entity.Dept;
import com.powernode.entity.Emp;
import com.powernode.util.ReflectUtil;

public class TestMain {
    public static void main(String[] args) throws Exception {
        testInsert();

    }

    private static void testInsert() throws Exception {

        Dept dept = new Dept(200, "后勤部门", "广州");
        String insert = ReflectUtil.createInsert(dept);
        System.out.println(insert);
        String update=ReflectUtil.createUpdate(dept);
        System.out.println(update);

        Emp emp = new Emp(77666, "Google", "saleman", 7698, "1994-01-11", 12000.0, 2345.0, 101);
        String insert1 = ReflectUtil.createInsert(emp);
        System.out.println(insert1);
        System.out.println(ReflectUtil.createUpdate(emp));
    }
}
