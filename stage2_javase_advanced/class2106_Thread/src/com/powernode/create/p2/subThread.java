package com.powernode.create.p2;

/**
 * 1. 定义类继承Thread
 */
public class subThread extends Thread {
    /**
     * 2. 重写Thread类中的run方法, run方法体就是子线程要执行的代码
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("sub Thread --------------------" + i);
        }
    }
}