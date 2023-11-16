package com.powernode.map.hash;

import java.util.ResourceBundle;

/**
 * @author wangjunchen
 * 使用ResourceBundle读取属性文件
 */
public class Test06ResourceBundle {
    public static void main(String[] args) {
        /*
         * 创建ResourceBundle对象,ResourceBundle是抽象类,调用它的静态方法getBundle(基础路径),其中基础路径不需要扩展名
         * 如果这一行出现MissingResourceException异常, 说明属性文件路径不正确
         */
        ResourceBundle bundle = ResourceBundle.getBundle("resources/config");

        //读取，属性名不正确,也会产生MissingResourceException异常
        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));
        System.out.println(bundle.getString("国籍"));
        System.out.println(bundle.getString("country"));

    }
}