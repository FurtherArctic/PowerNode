package com.powernode.serviceImpl;

import com.powernode.service.BaseService;

/**
 * 目标类1,在此类的方法上新增功能
 *
 * @author wangjunchen
 */
public class OneService implements BaseService {
    @Override
    public void service1() throws InterruptedException {
        System.out.println("OneService的service1方法开始运行了");
        Thread.sleep(1000);
    }
}
