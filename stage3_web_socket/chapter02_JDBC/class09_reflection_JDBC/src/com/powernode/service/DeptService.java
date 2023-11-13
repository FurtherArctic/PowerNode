package com.powernode.service;

import com.powernode.entity.Dept;

import java.util.List;

public interface DeptService {
    public int insertService(Dept dept) throws Exception;

    public int updateService(Dept dept) throws Exception;

    public int deleteService(int deptNo) throws Exception;

    public List<Dept> findAll() throws Exception;
}
