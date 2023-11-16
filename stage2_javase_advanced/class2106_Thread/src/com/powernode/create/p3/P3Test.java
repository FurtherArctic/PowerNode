package com.powernode.create.p3;

public class P3Test {
    public static void main(String[] args) {
        P3Prime prime = new P3Prime();
        Thread t = new Thread(prime);
        t.start();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("t2*****> " + i);
                }
            }
        });
        t2.start();

        Thread t3=new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("t3$$$$##@@> " + i);
            }
        });

        t3.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main==========> " + i);
        }
    }
}