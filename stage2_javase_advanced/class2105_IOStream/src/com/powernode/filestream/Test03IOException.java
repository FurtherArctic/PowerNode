package com.powernode.filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wangjunchen
 * IO流中的异常处理
 */
public class Test03IOException {
    public static void main(String[] args) {
        // m1();   //手动关闭流, 异常捕获
        m2();   //自动关闭流, 异常捕获
    }

    private static void m2() {
        //从JDK7开始,增加了try资源块, try资源块中创建的流会自动关闭
        //try关键后加一对小括弧, 就是try资源块
        try (FileOutputStream fos = new FileOutputStream("D:\\course\\03-JavaSE\\Day09\\def.txt")) {

            fos.write(66);
            fos.write(66);
            fos.write(66);
            fos.write(66);
            fos.write(66);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void m1() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\course\\03-JavaSE\\Day09\\abcd.txt");
            int bb = fis.read();
            while (bb != -1) {
                System.out.print((char) bb);     //把字节转换为字符打印出来
                bb = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流通道就是释放资源, 通常放在finally子句中
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}