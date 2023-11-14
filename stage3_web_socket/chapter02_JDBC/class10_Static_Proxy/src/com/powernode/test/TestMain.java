package com.powernode.test;

import com.powernode.aspect.MyAspect;

public class TestMain {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        MyAspect aspect = new MyAspect();
        aspect.invoke(1);
    }

    private static void test2() {
        MyAspect aspect = new MyAspect();
        aspect.invoke(2);
    }
}
