package com.powernode.aspect;

import com.powernode.service.BaseService;
import com.powernode.serviceImpl.OneService;
import com.powernode.serviceImpl.TwoService;

import java.util.Date;

/**
 * 切面类(代理类)
 */
public class MyAspect {
    BaseService target = null;

    /**
     * 后置新增功能
     */
    public void after() {
        System.out.println("service1方法运行结束的时间是:" + new Date());
    }

    /**
     * 前置新增功能
     */
    public void before() {
        System.out.println("service1方法运行开始的时间是:" + new Date());
    }

    /**
     * 异常通知
     *
     * @param error 异常信息
     */
    public void exception(String error) {
        System.out.println("service1方法运行时抛出了异常:" + error);
    }

    public void finalFunc() {
        System.out.println("最终通知");
    }

    /**
     * 目标方法调用,新增功能调用
     */
    public void invoke(int flag) {
        //1. 调用目标方法
        if (flag == 1) {
            target = new OneService();
        } else if (flag == 2) {
            target = new TwoService();
        }
        //2. 调用新增功能
        before(); //前置通知
        try {
            if (target != null) {
                target.service1();
            }
        } catch (Exception e) {
            exception(e.getMessage());//异常通知
        } finally {
            finalFunc();//最终通知
        }
        after();//后置通知
    }
}
