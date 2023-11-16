package com.powernode.filerw;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author wangjunchen
 * FileReader从文件中读取字符
 */
public class Test01FileReader {
    public static void main(String[] args) throws IOException {
        //m1();
        m2();
    }

    public static void m1() throws IOException {
        FileReader fr = new FileReader("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt");

        char[] chars = new char[1024 * 8];
        int len = fr.read(chars);
        while (len != -1) {
            System.out.println(new String(chars, 0, len));
            len = fr.read(chars);
        }
        fr.close();
    }

    public static void m2() throws IOException {
        FileReader fr = new FileReader("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt");
        int code = fr.read();
        while (code != -1) {
            System.out.println((char) code);
            code = fr.read();
        }

        fr.close();
    }
}