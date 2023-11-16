package com.powernode.serviceImpl;

import com.powernode.service.BaseService;

/**
 * 目标类2,在此类的方法上新增功能
 *
 * @author wangjunchen
 */
public class TwoService implements BaseService {
    @Override
    public void service1() throws InterruptedException {
        System.out.println("TwoService的Service1方法开始运行了");
        Thread.sleep(1000);
        int i = 1 / 0;
    }

    @Override
    public void service2(int p1, int p2) throws Exception {
        int i = p1 * p2;
        System.out.println("TwoService的service2方法提供乘法运算服务:" + p1 + " * " + p2 + " = " + i);
    }
}
