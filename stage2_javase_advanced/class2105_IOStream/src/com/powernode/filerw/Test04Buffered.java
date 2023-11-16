package com.powernode.filerw;

import java.io.*;

public class Test04Buffered {
    public static void main(String[] args) throws IOException {
        m1();
    }

    public static void m1() throws IOException {
        //先创建fileReader
        FileReader fr = new FileReader("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt");
        //再创建BufferedReader对fr进行缓冲
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
        fr.close();
    }

    public static void m2() throws IOException {
        //先创建FileWriter
        FileWriter fw = new FileWriter("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt", true);
        //再创建BufferedWriter对fw进行缓冲
        BufferedWriter bw = new BufferedWriter(fw);

        //向bw的缓冲区中写入数据
        bw.newLine();       //换行,在Windows系统, Linux系统不同系统中换行操作不一样
        bw.write("向bw的缓冲区中写入数据, 这些数据并没有立即写入文件");

        //bw.flush(); //刷新缓冲区

        bw.close();
        fw.close();
    }
}