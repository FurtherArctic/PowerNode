package com.powernode.method;

public class Test02 {
    public static void main(String[] args) {
        ClassLoader classLoader = Test02.class.getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);
        System.out.println(contextClassLoader);
        System.out.println(classLoader == contextClassLoader);
    }
}