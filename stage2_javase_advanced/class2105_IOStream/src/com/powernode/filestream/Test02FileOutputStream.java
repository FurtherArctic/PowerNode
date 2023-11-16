package com.powernode.filestream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wangjunchen
 * FileOutputStream可以向文件中写入字节
 */
public class Test02FileOutputStream {
    public static void main(String[] args) throws IOException {
        m1();
    }

    public static void m1() throws IOException {
        FileOutputStream fos = new FileOutputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/java.txt");

        byte[] bytes = "HelloWorld,你好世界".getBytes();
        fos.write(bytes);//写入字节数组
        fos.write(123);//写入byte数据
        fos.write(bytes, 2, 13);//写入字节数组的一部分，但是三个字节组成一个汉字，如果截取的最后部分数据无法组成一个汉字字符，则会出现乱码

        fos.close();
    }
}