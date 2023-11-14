package com.powernode.aspect;

import com.powernode.service.BaseService;

import java.lang.reflect.Method;
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
        System.out.println("后置通知, 方法运行结束的时间是:" + new Date());
    }

    /**
     * 前置新增功能
     */
    public void before() {
        System.out.println("前置通知, 方法运行开始的时间是:" + new Date());
    }

    /**
     * 异常通知
     *
     * @param error 异常信息
     */
    public void exception(String error) {
        System.out.println("异常通知, 方法运行时抛出了异常:" + error);
    }

    public void finalFunc() {
        System.out.println("最终通知, 程序结束");
    }

    /**
     * @param targetClass  目标类
     * @param targetMethod 目标方法
     * @param param        目标方法参数列表
     * @throws Exception 异常
     */
    public void invoke(Class<?> targetClass, Method targetMethod, Object... param) throws Exception {
        //1. 调用目标方法
        target = (BaseService) targetClass.getConstructor().newInstance();
        //2. 调用新增功能
        before(); //前置通知
        try {
            if (this.target != null) {
                targetMethod.invoke(target, param);
            }
        } catch (Exception e) {
            exception(e.getMessage());//异常通知
        } finally {
            finalFunc();//最终通知
        }
        after();//后置通知
    }
}
