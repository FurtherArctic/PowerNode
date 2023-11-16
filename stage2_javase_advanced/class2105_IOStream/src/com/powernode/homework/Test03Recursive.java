package com.powernode.homework;

import java.io.File;

public class Test03Recursive {
    public static void main(String[] args) {
        String path = "/Volumes/ExternalHD/Projects/java/PowerNode/stage2_javase_advanced";
        listSubFiles(path);
    }

    /**
     * 显示路径中所有文件夹及其子文件夹中的内容
     *
     * @param folder 文件夹路径
     */
    public static void listSubFiles(String folder) {
        File file = new File(folder);

        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File listFile : listFiles) {
                System.out.println(listFile);
                if (listFile.isDirectory()) {
                    listSubFiles(listFile.getAbsolutePath());
                    System.out.println();
                }
            }
        }
    }

    /**
     * 删除文件夹，若文件夹不为空，先删除其中的内容，然后删除文件夹，采用递归方法
     *
     * @param folder 文件夹路径
     */
    private static void deleteFolder(String folder) {
        //根据参数接收的文件夹路径创建File对象
        File file = new File(folder);

        //先删除文件夹中的内容,使文件夹变为空文件夹
        File[] listFiles = file.listFiles();    //获得文件夹内容
        if (listFiles != null) {
            //遍历文件夹的内容
            for (int i = 0; i < listFiles.length; i++) {
                File subFile = listFiles[i];
                //如果内容是文件,则直接删除
                if (subFile.isFile()) {
                    subFile.delete();
                } else {
                    //subFile不是文件,就是子文件夹, 删除subFile这个子文件夹,需要递归调用
                    deleteFolder(subFile.getAbsolutePath());
                }
            }
        }
    }
}