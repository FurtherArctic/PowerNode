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
}
