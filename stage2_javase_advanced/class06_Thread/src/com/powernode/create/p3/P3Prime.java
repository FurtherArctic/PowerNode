package com.powernode.create.p3;

public class P3Prime implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("P3Prime----------" + i);
        }
    }
}