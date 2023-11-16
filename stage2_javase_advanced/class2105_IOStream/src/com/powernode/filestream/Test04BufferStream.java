package com.powernode.filestream;

import java.io.*;

public class Test04BufferStream {
    public static void main(String[] args) throws IOException {
        m1();
        m2();
    }

    private static void m2() throws IOException {
        //先创建FileOutputStream输出字节流
        FileOutputStream fos = new FileOutputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/data.txt");
        //再创建BufferedOutputStream对fos进行缓冲
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //向 bos 的缓冲区中写入数据
        bos.write(97);
        bos.write(97);
        bos.write(97);
        bos.write(97);
        bos.write(97);
        bos.write(97);
        bos.write(97);

        //手动刷新缓冲区
        //bos.flush();

        //一般情况下, 关闭资源的顺序与打开资源的顺序相反
        bos.close();
        fos.close();
    }

    private static void m1() {
        try (
                FileInputStream fis = new FileInputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/data.txt");
                //创建BufferedInputStream缓冲字节流, 通过构造方法指定对哪个InputStream输入字节流进行缓冲
                BufferedInputStream bis = new BufferedInputStream(fis);
        ) {
            //从bis的缓冲区中读取数据
            int bb = bis.read();
            while (bb != -1) {
                System.out.print((char) bb);
                bb = bis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}