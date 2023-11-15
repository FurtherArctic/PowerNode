package com.powernode.test;

import com.powernode.aspect.MyAspect;
import com.powernode.service.BaseService;
import com.powernode.serviceImpl.OneService;
import com.powernode.serviceImpl.ThreeService;
import com.powernode.serviceImpl.TwoService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestMain {
    //private static final MyAspect aspect = new MyAspect();

    public static void main(String[] args) throws Exception {
        test1();
        System.out.println("===============================");
        test2();
        System.out.println("===============================");
        test3();
    }

    /**
     * 调用OneService中的service1方法. 不需要开发人员亲自调用[切面类],但是开发人员需要亲自获得代理对象
     *
     * @throws Exception 异常
     */
    private static void test1() throws Exception {
        //创建代理对象
        //1. 获取类加载器,可以在内存中定义生成一个代理类. 所有类和接口都可以用来获取类加载器
        ClassLoader loader = TestMain.class.getClassLoader();
        //2. 获取目标类(代理类)实现的接口
        Class<?>[] interfaces = {BaseService.class};
        //3. 获取InvocationHandler调用处理程序对象,即切面类实例对象
        InvocationHandler h = new MyAspect(new OneService());
        //代理类和目标类实现同一个接口,因此可以接口对象指向此代理类实例对象
        BaseService proxy = (BaseService) Proxy.newProxyInstance(loader, interfaces, h);

        //调用目标方法
        proxy.service1();
    }

    private static void test2() throws Exception {
        //创建代理对象
        //1. 获取类加载器,可以在内存中定义生成一个代理类. 所有类和接口都可以用来获取类加载器
        ClassLoader loader = TestMain.class.getClassLoader();
        //2. 获取目标类(代理类)实现的接口
        Class<?>[] interfaces = {BaseService.class};
        //3. 获取InvocationHandler调用处理程序对象,即切面类实例对象
        InvocationHandler h = new MyAspect(new TwoService());
        //代理类和目标类实现同一个接口,因此可以接口对象指向此代理类实例对象
        BaseService proxy = (BaseService) Proxy.newProxyInstance(loader, interfaces, h);

        //调用目标方法
        proxy.service1();
        //proxy.service2(12, 3);
    }

    private static void test3() throws Exception {
        //创建代理对象
        //1. 获取类加载器,可以在内存中定义生成一个代理类. 所有类和接口都可以用来获取类加载器
        ClassLoader loader = TestMain.class.getClassLoader();
        //2. 获取目标类(代理类)实现的接口
        Class<?>[] interfaces = {BaseService.class};
        //3. 获取InvocationHandler调用处理程序对象,即切面类实例对象
        InvocationHandler h = new MyAspect(new ThreeService());
        //代理类和目标类实现同一个接口,因此可以接口对象指向此代理类实例对象
        BaseService proxy = (BaseService) Proxy.newProxyInstance(loader, interfaces, h);

        //调用目标方法
        //proxy.service1();
        proxy.service2(12, 3);
    }
}
