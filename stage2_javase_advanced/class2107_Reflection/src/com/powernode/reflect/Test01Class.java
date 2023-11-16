package com.powernode.reflect;

/**
 * @author wangjunchen
 */
public class Test01Class {
    public static void main(String[] args) throws ClassNotFoundException {
        //每个类都有class属性
        Class<String> stringClass = String.class;
        //每个对象都有getClass方法,继承自Object类
        String s1 = "Hello";
        Class<? extends String> aClass = s1.getClass();
        //直接调用Class.forName("全限定类名")
        Class<?> aClass1 = Class.forName("java.lang.String");

        //输出结果都是java.lang.String
        System.out.println(stringClass);
        System.out.println(aClass);
        System.out.println(aClass1);

        //输出结果都是true
        System.out.println(stringClass == aClass);
        System.out.println(stringClass == aClass1);
        System.out.println(aClass1 == aClass);
    }
}
