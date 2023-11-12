package com.powernode.serviceImpl;

import com.powernode.dao.DeptDao;
import com.powernode.dao.EmpDao;
import com.powernode.entity.Dept;
import com.powernode.service.DeptService;

import java.util.List;

public class TwoServiceImpl implements DeptService {
    private final DeptDao deptDao = new DeptDao();
    private final EmpDao empDao = new EmpDao();

    @Override
    public int insertService(Dept dept) throws Exception {
        return deptDao.insertDept(dept);
    }

    @Override
    public int updateService(Dept dept) throws Exception {
        return deptDao.updateDao(dept);
    }

    /**
     * 删除部门信息,同时删除该部门下的所有职员信息
     *
     * @param deptNo 部门编号
     * @return 删除结果
     * @throws Exception 异常
     */
    @Override
    public int deleteService(int deptNo) throws Exception {
        int result1 = empDao.deleteEmp(deptNo);
        int result2 = deptDao.deleteDao(deptNo);
        return result1 == result2 ? 1 : 0;
    }

    @Override
    public List<Dept> findAll() throws Exception {
        return deptDao.findAll();
    }
}
