package com.powernode.file;

import java.io.File;

public class Test02Directory {
    public static void main(String[] args) {
        //1 创建File对象关联文件夹
        //调用File(String pathname) 构造方法,参数指定文件夹的路径
        File f1 = new File("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream");
        //File(String parent, String child) 第一个参数指定上级目录, 第二个参数指定当前文件夹
        File f2 = new File("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream", "resource");
        //File(File parent, String child) 第一个参数上级 目录还可以是一个File对象
        File f3 = new File(f1, "resource");
        //关联的文件夹可以是不存在的
        File f4 = new File(f2, "sub");
        File f5 = new File("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/test05/directory04");

        //创建文件夹, 如果文件夹已存在则返回false表示创建失败
        boolean result;
        System.out.println(f1.mkdir());
        System.out.println(f2.mkdir());
        System.out.println(f3.mkdir());
        System.out.println(f4.mkdir());
        System.out.println(f5.mkdir());

        System.out.println("===========================================");
        //result = f5.mkdir();        //mkdir()创建文件夹时,如果上级上级目录不存在则创建失败
        result = f5.mkdirs();           //mkdirs()创建文件夹,如果上级目录不存在则先创建上级目录
        System.out.println(result);

        result = f4.delete();
        System.out.println(result);    //true表示删除成功
        result = f1.delete();
        System.out.println(result); //false, delete()只能删除空文件夹

        //查看文件夹内容
        File[] files = f2.listFiles();  //返回文件夹内容, File对象既可以是文件,也可以是文件夹,如果f1对象关联的是文件,则方法返回null
        if (files != null) {
            for (File subFile : files) {
                System.out.println(subFile);
            }
        }
    }
}