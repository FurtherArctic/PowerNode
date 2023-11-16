package com.powernode.string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class String02Method {
    public static void main(String[] args) {
        String s = "Hello动力节点";     //创建了String字符串对象, 把"Hello动力节点"保存到这个对象的value数组中
        System.out.println(s.charAt(6));  //H
        System.out.println(s.length());   //9
        //通过for循环遍历 字符串的每个字符
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + "    ");
        }
        System.out.println();

        String s2 = "heima";
        System.out.println(s.concat(s2));
        System.out.println(s);
        System.out.println(s2);

        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = s.getBytes(StandardCharsets.US_ASCII);
        System.out.println(Arrays.toString(bytes1));

        String path = "D:\\Projects\\java\\powernode\\stage2_javase_advanced\\class02_common_classes\\src\\com\\powernode\\string\\String02Method.java";
        System.out.println(path.indexOf('j'));
        System.out.println(path.lastIndexOf("src"));

        System.out.println(path.substring(34, 67));
        String s3 = "java";

        System.out.println(Arrays.toString(path.split(s3)));

        System.out.println(Arrays.toString(path.toCharArray()));

        String s1 = "      1 2 3 4 frs re w rwr fdf sf     ";
        System.out.println(s1);
        System.out.println(s1.trim());

        char[] chars = s1.trim().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                count++;
            }
        }
        System.out.println(Arrays.toString(chars));
        char[] newChars = new char[count];

        for (int i = 0, j = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                newChars[j] = chars[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(newChars));

        String newString = new String(newChars);
        System.out.println(newString);

    }
}