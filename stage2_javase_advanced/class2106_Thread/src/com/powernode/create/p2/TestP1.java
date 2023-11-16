package com.powernode.create.p2;

/**
 * 运行程序后, JVM启动main线程,在main线程开启t线程, t线程执行run方法, 现在main线程与t两个线程并发执行
 * 注意: 线程执行是随机的,每次运行结果可能都不一样
 * start()方法调用的先后顺序, 并不一定就是线程开启的先后顺序
 * 直接调用线程对象的run方法不会开启线程, 仅仅是普通实例方法的调用
 * run方法运行结束后, 子线程就结束了
 */
public class TestP1 {
    public static void main(String[] args) {
        subThread t = new subThread();

        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main===> " + i);
        }
    }
}