package com.powernode.serviceImpl;

import com.powernode.dao.DeptDao;
import com.powernode.entity.Dept;
import com.powernode.service.DeptService;

import java.util.List;

public class OneServiceImpl implements DeptService {
    private final DeptDao deptDao = new DeptDao();

    @Override
    public int insertService(Dept dept) throws Exception {
        return deptDao.insertDept(dept);
    }

    @Override
    public int updateService(Dept dept) throws Exception {
        return deptDao.updateDao(dept);
    }

    /**
     * 删除指定部门
     *
     * @param deptNo 部门编号
     * @return 删除结果
     * @throws Exception 异常
     */
    @Override
    public int deleteService(int deptNo) throws Exception {
        return deptDao.deleteDao(deptNo);
    }

    @Override
    public List<Dept> findAll() throws Exception {
        return deptDao.findAll();
    }
}
