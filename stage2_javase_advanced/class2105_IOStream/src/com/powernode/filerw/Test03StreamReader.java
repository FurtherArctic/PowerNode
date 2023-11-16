package com.powernode.filerw;

import java.io.*;

public class Test03StreamReader {
    public static void main(String[] args) throws IOException {
        m2();
    }

    public static void m1() throws IOException {
        FileInputStream fis = new FileInputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt");
        InputStreamReader isr=new InputStreamReader(fis,"GB2312");
        int code=isr.read();
        while (code!=-1) {
            System.out.println((char) code);
            code=isr.read();
        }
        isr.close();
        fis.close();
    }

    public static void m2()throws IOException{
        FileOutputStream fos=new FileOutputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt",true);
        OutputStreamWriter osw=new OutputStreamWriter(fos,"GB2312");
        osw.write("/Volumes/ExternalHD/Projects/java/PowerNode/");
        osw.close();
        fos.close();
    }
}