package com.powernode.aspect;

import com.powernode.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 切面类(代理类)
 */
public class MyAspect implements InvocationHandler {
    /**
     * 为类中的属性初始化通常只有两种方式:调用对应的get方法或者指定该属性的有参构造
     */
    BaseService target;

    //通过有参构造为目标对象属性赋值
    public MyAspect(BaseService target) {
        this.target = target;
    }

    /**
     * @param proxy  调用这个方法的代理实例,ClassLoader在内存中创建的代理类的实例对象,开发者无法查看此类的名字与内容
     * @param method 要调用的方法
     * @param args   方法调用时所需要的参数
     * @return 方法调用的结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        before(method.getName());
        //调用目标方法
        Object result = null;
        try {
            result = method.invoke(target, args);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            exception(method.getName(), e.getMessage());
        } finally {
            finalFunc(method.getName());
        }

        //调用新增功能
        after(method.getName());
        return result;
    }


    /**
     * 后置新增功能
     */
    public void after(String methodName) {
        System.out.println("后置通知," + methodName + "方法运行结束的时间是:" + new Date());
    }

    /**
     * 前置新增功能
     */
    public void before(String methodName) {
        System.out.println("前置通知," + methodName + " 方法运行开始的时间是:" + new Date());
    }

    /**
     * 异常通知
     *
     * @param error 异常信息
     */
    public void exception(String methodName, String error) {
        System.out.println("异常通知, " + methodName + "方法运行时抛出了异常:" + error);
    }

    public void finalFunc(String methodName) {
        System.out.println("最终通知," + methodName + " 程序结束");
    }

}
