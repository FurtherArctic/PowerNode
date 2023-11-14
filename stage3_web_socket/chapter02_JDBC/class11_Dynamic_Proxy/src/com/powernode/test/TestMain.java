package com.powernode.test;

import com.powernode.aspect.MyAspect;
import com.powernode.serviceImpl.OneService;
import com.powernode.serviceImpl.ThreeService;
import com.powernode.serviceImpl.TwoService;

import java.lang.reflect.Method;

public class TestMain {
    private static final MyAspect aspect = new MyAspect();

    public static void main(String[] args) throws Exception {
        test1();
        System.out.println("===============================");
        test2();
        System.out.println("===============================");
        test3();
    }

    private static void test1() throws Exception {
        //MyAspect aspect = new MyAspect();

        Class<OneService> oneServiceClass = OneService.class;
        Method service1 = oneServiceClass.getDeclaredMethod("service1");
        //aspect.invoke(oneServiceClass, service1, null);

        Method service2 = oneServiceClass.getDeclaredMethod("service2", int.class, int.class);
        aspect.invoke(oneServiceClass, service2, 12, 3);
    }

    private static void test2() throws Exception {
        //MyAspect aspect = new MyAspect();

        Class<TwoService> twoServiceClass = TwoService.class;
        Method service1 = twoServiceClass.getDeclaredMethod("service1");
        //aspect.invoke(twoServiceClass, service1, null);

        Method service2 = twoServiceClass.getDeclaredMethod("service2", int.class, int.class);
        aspect.invoke(twoServiceClass, service2, 12, 3);
    }

    private static void test3() throws Exception {
        //MyAspect aspect = new MyAspect();
        Class<ThreeService> threeServiceClass = ThreeService.class;
        Method service1 = threeServiceClass.getDeclaredMethod("service1");
        //aspect.invoke(threeServiceClass, service1, null);
        Method service2 = threeServiceClass.getDeclaredMethod("service2", int.class, int.class);
        aspect.invoke(threeServiceClass, service2, 12, 3);
    }
}
