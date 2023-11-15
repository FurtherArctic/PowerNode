package com.powernode.serviceImpl;

import com.powernode.service.BaseService;

public class ThreeService implements BaseService {
    @Override
    public void service1() throws InterruptedException {
        System.out.println("ThreeService的service1方法开始运行了");
    }

    @Override
    public void service2(int p1, int p2) throws Exception {
        int i = p1 - p2;
        System.out.println("ThreeService的service2方法提供减法运算服务:" + p1 + " - " + p2 + " = " + i);
    }
}
