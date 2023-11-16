package com.powernode.filestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Test06PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
//        PrintStream printStream = new PrintStream("D:\\course\\03-JavaSE\\Day09\\log.txt");  //虽然通过构造方法指定一个文件路径, 底层会根据这个文件路径创建FileOutputStream流对象, 即PrintStream不直接操作文件,不是节点流
        PrintStream printStream = new PrintStream(new FileOutputStream("/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced/class05_IOStream/resource/log.txt", true));

        printStream.print("PrintStream打印字节流的print方法打印完后不换行,");
        printStream.println("PrintSTream的println方法打印完后会换行");

        //异常也可以打印到printStream流
        try {
            byte[] bytes = "Hello动辄 节点".getBytes("adsjlkdfjldfasj");
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();    //把异常打印到屏幕上
            e.printStackTrace(printStream); //把异常打印到printStream流关联的log.txt文件中
        }

        //其实System类的静态变量 out 就是一个PrintStream打印字节流
        System.out.println("System.out代表系统标准输出设备,即显示器");

        printStream.close();
    }
}