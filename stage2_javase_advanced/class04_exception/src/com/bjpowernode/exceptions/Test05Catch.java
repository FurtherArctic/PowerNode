package com.bjpowernode.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test05Catch {
    //try代码块有多个检查异常, 通过多个catch子句分别捕获,分别处理
    private static void m1() {
        try {
            FileInputStream fis = new FileInputStream("abc.txt");   //有FileNotFoundException检查异常
            byte[] bytes = new byte[1024];
            int len = fis.read(bytes);      //有IOException检查 异常
            String s = new String(bytes, 0, len, "GBK");    //有UnsupportedEncodingException检查 异常
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果catch子句捕获的异常类没有继承关系,则catch子句没有先后顺序; 如果有继承关系则先捕获子异常,再捕获父异常
    }

    //如果try代码块中的多个检查异常采用相同的处理方式,使用一个catch子句直接捕获父异常
    private static void m2(){
        try {
            FileInputStream fis = new FileInputStream("abc.txt");   //有FileNotFoundException检查异常
            byte[] bytes = new byte[1024];
            int len = fis.read(bytes);      //有IOException检查 异常
            String s = new String(bytes, 0, len, "GBK");    //有UnsupportedEncodingException检查 异常
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}