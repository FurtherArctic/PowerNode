package com.powernode.filestream;

import java.io.*;

public class Test05DataStream {
    public static void main(String[] args) throws IOException {
        //m1();   //先通过DataOutputStream向文件中写入数据
        m2();   //通过DataInputStream读取文件中的数据
    }

    private static void m2() throws IOException {
        FileInputStream fis = new FileInputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/data2.txt");
        DataInputStream dis = new DataInputStream(fis);

        //读取的顺序与写入的顺序要一致
        int i = dis.readInt();  //从文件中读取4个字节解析为int整数
        double v = dis.readDouble();    //从文件中读取8个字节解析为小数
        char c = dis.readChar();
        boolean b = dis.readBoolean();
        String s = dis.readUTF();
        //String s2 = dis.readUTF();  //EOFException, 已读到文件末尾
        dis.close();

        System.out.println(i);
        System.out.println(v);
        System.out.println(c);
        System.out.println(b);
        System.out.println(s);
    }

    private static void m1() throws IOException {
        FileOutputStream fos = new FileOutputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/data2.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(456);    //写入整数
        dos.writeDouble(3.14);
        dos.writeChar('字');
        dos.writeBoolean(true);
        dos.writeUTF("字符串");
        //直接打开文件,显示乱码, 该文件内容需要通过FileInputStream读取
        dos.close();
    }
}