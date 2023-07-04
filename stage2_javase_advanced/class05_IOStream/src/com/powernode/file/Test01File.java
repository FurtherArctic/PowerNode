package com.powernode.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Test01File {
    public static void main(String[] args) throws IOException {
        //1 创建File对象关联文件
        //File(String pathname) 通过参数指定关联文件的路径
        File f1 = new File("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/abc.txt");
        //File(String parent, String child) 构造方法第一个参数指定文件夹, 第二个参数指定文件名
        File f2 = new File("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource", "abc.txt");
        //File对象既可以关联存在的文件,也可以关联不存在的文件
        File f3 = new File("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource", "Test01File01.txt");
        //文件路径可以是绝对路径 ,也可以是相对路径, 在javaSE项目中相对于当前项目目录:/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced
        File f4 = new File("Test01File02.txt");

        //2 创建/删除文件
        boolean result = f1.createNewFile();    //创建文件,如果文件路径不正确抛出异常, 如果文件存在则创建失败返回false, 文件不存在创建成功返回true
        System.out.println(result);
        result = f3.createNewFile();
        System.out.println(result);

        //如果文件已存在则先删除, 再创建新文件
        if (f4.exists()) {
            f4.delete();
        }
        f4.createNewFile();

        //查看文件属性
        System.out.println(f4.getAbsolutePath());     //绝对路径
        System.out.println(f1.getName());     //文件名
        System.out.println(f1.length());  //文件大小
        long modified = f1.lastModified();  //最后一次修改时间
        System.out.println(new Date(modified));
    }
}