package com.powernode.method;

public class Test05 {
    public static void main(String[] args) {

        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + i);
            }
        };

        Thread t1 = new Thread(r,"t1");
        System.out.println(t1.getPriority());
        t1.setPriority(1);
        System.out.println(t1.getPriority());
        t1.start();
        Thread t2 = new Thread(r,"t2");
        t2.setPriority(6);
        t2.start();
    }
}