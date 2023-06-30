package com.bjpowernode.exceptions;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test04Try {
    public static void main(String[] args) {
        String text = "hello动力节点";

        convert(text, "UTF-8");
        convert(text, "GBK");
        convert(text, "GBKKKKKK");

        System.out.println("main....其他代码......");
    }

    public static void convert(String str, String charsetName) {
        //可以把一组相关的代码都放在Try代码块中
        try {
            byte[] bytes = str.getBytes(charsetName);
            //如果上面一行代码没有异常,则执行下面的打印字节数组, 不执行catch
            //如果上面代码产生了异常,则不执行try代码块后面的其他代码了, 会立即跳转到catch子句
            System.out.println(Arrays.toString(bytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void convert1(String str, String charsetName) {
        //对编译异常进行捕获处理, Alt+Enter, 选择 Surround with try/catch
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /* 运行程序后，如果bytes = str.getBytes(charsetName)这一行没有产生异常，不执行catch子句，程序正常向下执行
         * 如果 bytes = str.getBytes(charsetName);产生了异常，程序立即跳转到catch子句，通常会在catch子句中对异常做如下处理:
         * 1) 打印异常栈跟踪信息,方便调试；
         * 2) 把异常跟踪信息打印到日志文件中；
         * 3) 有时还会通知运维人员；
         * 4) 还可以把捕获的异常继续上抛。
         * 运行程序产生的异常被catch捕获后，就不再继续上抛了，程序也不会中断，还会继续向下执行，即异常的捕获处理可以提高程序的健壮性*/
        System.out.println(Arrays.toString(bytes));
    }
}