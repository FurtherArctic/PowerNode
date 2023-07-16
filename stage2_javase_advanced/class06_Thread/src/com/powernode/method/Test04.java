package com.powernode.method;

public class Test04 {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("当前线程名称为：" + Thread.currentThread().getName());
            System.out.println("当前线程的id为：" + Thread.currentThread().getId());
        };
        Thread t0 = new Thread(r);
       // t0.start();

        Thread t2 = new Thread(r, "t2");
        //t2.start();

        Thread t3 = new Thread(r);
        //t3.start();

        Thread t4 = new Thread(r);
        t4.setName("t4");
        t4.start();
    }
}