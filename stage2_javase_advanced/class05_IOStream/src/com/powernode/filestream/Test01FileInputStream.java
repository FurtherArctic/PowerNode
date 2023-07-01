package com.powernode.filestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author wangjunchen
 * FileInputStream可以从文件中读取字节
 */
public class Test01FileInputStream {
    public static void main(String[] args) throws IOException {
        m2();
        m1();
    }

    private static void m2() throws IOException {
        // 1.创建流通道.abc.txt:abcdefgworld
        FileInputStream fis = new FileInputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/data.txt");
        /* 2.读取文件中的字节，调用read方法读取文件中的一个字节，并返回读取的字节，
         * 如果读到文件末尾返回-1
         */

        int i = 0;
        while (i != -1) {
            i = fis.read();
            System.out.println((char) i);
        }
        // 3.关闭流通道
        fis.close();

    }

    private static void m1() throws IOException {
        // 1.创建流通道
        FileInputStream fis = new FileInputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt");

        byte[] bytes = new byte[8];
        int len = fis.read(bytes);
        while (len != -1) {
            System.out.println("本次读取到的字节数量为：" + len);
            System.out.println("本次读取的数组为：" + Arrays.toString(bytes) + "，其对应的字符串为：" + new String(bytes, 0, len));
            len = fis.read(bytes);
        }
        // 3.关闭流通道
        fis.close();

    }
}