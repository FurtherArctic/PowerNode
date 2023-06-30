package com.bjpowernode.exceptions;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test06Finally {
    public static void main(String[] args) {
        try {
            byte[] gbks = "hello动力节点".getBytes("GBK");
            System.out.println(Arrays.toString(gbks));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            System.out.println("try代码块没有异常, 不执行catch子句, 执行finally....");
        }
        System.out.println("------------------------------------------------------");

        try {
            byte[] gbks = "hello动力节点".getBytes("GBK123");
            System.out.println(Arrays.toString(gbks));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            System.out.println("try代码块产生异常, 立即执行catch子句, 执行finally....");
        }

        int g = 10;
        for (int i = 0; i < 5; i++) {
            int x = mm(g);
            System.out.println(x); // 10
            System.out.println(g);
        }

        int a = 10;
        int b = a; // 把变量a当前的值10赋值给b
        a++;
        System.out.println(b); // 10
    }

    private static int mm(int i) { // i=10
        try {
            return i; // 程序执行到 return i时, i的值是10,这条指令就是return 10; finally子句总是会执行,所以程序不会立即执行return 10 ,
            // 会先执行finally, 然后再回来执行return 10;
        } finally {
            i++;
        }
    }
}