package com.powernode.homework;

import java.io.*;

public class Test01CopyFile {
    public static void main(String[] args) throws IOException {
        String srcPath="/Volumes/ExternalHD/Documents/PowerNode/Java阶段2-进阶/Day10/Video/01 定义方法实现文件复制.avi";

        String destPath="//Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/01.avi";
        copyFile(srcPath, destPath);
    }

    public static void copyFile(String src, String dest) throws IOException {
        FileInputStream fis= new FileInputStream(src);
        BufferedInputStream bis= new BufferedInputStream(fis);

        FileOutputStream fos=new FileOutputStream(dest);
        BufferedOutputStream bos=new BufferedOutputStream(fos);

        int bb=bis.read();
        while (bb!=-1) {
            bos.write(bb);
            bb=bis.read();
        }

        bos.flush();

        bis.close();
        fis.close();
        bos.close();
        fos.close();
    }
}