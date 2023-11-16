package com.powernode.method;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        for (Thread t : threads) {
            System.out.println(t);
        }

        System.out.println("--------------------------------");
        Thread thread = Thread.currentThread();
        System.out.println(thread);

        subThread p = new subThread();
        p.start();
        //System.out.println(thread1);
    }
}

class subThread extends Thread {
    public subThread() {
        System.out.println("SubThread构造方法中当前线程为: " + Thread.currentThread());
    }

    @Override
    public void run() {
        System.out.println("run方法中的当前线程为：" + Thread.currentThread());
    }
}