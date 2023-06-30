package com.bjpowernode.exceptions;

public class Test02RuntimeException {
    public static void main(String[] args) {
        divide(12, 4);
        divide(31, 3);
        divide(12, 0);
    }

    public static void divide(int m, int n) {
        if (n == 0) {
            System.out.println("除数不能为0");
            return;
        }
        int result = m / n;
        System.out.println(m + " / " + n + " = " + result);
    }
}