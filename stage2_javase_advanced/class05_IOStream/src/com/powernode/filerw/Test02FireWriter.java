package com.powernode.filerw;

import java.io.FileWriter;
import java.io.IOException;

public class Test02FireWriter {
    public static void main(String[] args) throws IOException {
        m1();
    }

    public static void m1() throws IOException {
        FileWriter fw = new FileWriter("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc_w.txt");
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};

        fw.write("abc"); //写入字符串
        fw.write(123);//将整型数据转为char型写入
        fw.write('A');//写入char字符
        fw.write('q');
        fw.write(',');
        fw.write('8');
        fw.write(chars);//写入char字符数组
        fw.flush();
        fw.close();
    }

    public static void m2() {

    }
}