package com.bjpowernode.exceptions;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test03Throws {
    public static void main(String[] args) {

    }

    public static void convert(String str, String charsetName) throws UnsupportedEncodingException {
        /* 调用String类的实例方法getBytes(String charsetName)可以把字符串转换为指定的charsetName编码的字节数组
         * 调用方法后显示语法错误:Unhandled exception: java.io.UnsupportedEncodingException未处理的异常
         * String类中的getBytes(String charsetName)方法在声明行通过throws声明抛出了 UnsupportedEncodingException 异常,而这个异常类没有继承 RuntimeException类,
         * 就是编译异常,检查异常. 根据语法错误必须进行预处理的.
         * 当前选择抛出处理. Alt+Enter,选择 Add exception to method signature, 就会在当前方法声明行通过throws声明抛出这个异常, 抛出给调用者, 谁调用convert方法谁负责处理这个异常。
         * 在main方法中调用convert方法, 也对这个异常选择抛出处理, 抛出给JVM处理。
         * 运行当前程序, JVM自动执行main方法, main调用convert方法, convert方法调用String字符串的getBytes(String)方法, 如果给定的字符编码java能够支持,没有产生异常, getBytes方法体正常执行,把字符串转换为字节数组。
         * 运行当前程序, 如果给定的字符编码java不支持, 在调用getBytes(String)方法体中会抛出UnsupportedEncodingException异常给convert, convert把这个异常抛出给main，main抛出给JVM，JVM默认的处理方式是中断程序执行，打印异常栈跟踪信息
         * */
        byte[] bytes = str.getBytes(charsetName);
        System.out.println(Arrays.toString(bytes));
    }
}