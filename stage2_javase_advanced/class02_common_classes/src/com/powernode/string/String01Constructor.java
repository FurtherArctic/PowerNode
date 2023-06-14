package com.powernode.string;

import java.nio.charset.StandardCharsets;

public class String01Constructor {
    public static void main(String[] args) {
        //直接赋值
        String s1 = "Application";
        System.out.println(s1);
        //从字节数组创建
        byte[] bytes = {97, 1, 98, 4, 99, 12, 100, 3, 101, -27, -34, -45};
        String s2 = new String(bytes);
        System.out.println(s2);
        String s3 = new String(bytes, 2, 4);
        System.out.println(s3);
        String s4 = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s4);
        String s5 = new String(bytes, StandardCharsets.ISO_8859_1);
        System.out.println(s5);
        //从字符数组创建
        char[] chars = {89, 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 3456, '@', 1234, 54311, 'J', '王'};
        String s6 = new String(chars);  //Ydefghijk඀@Ӓ퐧J王
        String s7 = new String(chars, 2, 9);  //efghijk඀@
        System.out.println(s7);
    }
}