package com.powernode.map.hash;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangjunchen
 * 1.在实际开发中，经常会在src源文件夹下创建一个resources资源包，在该包中会添加属性文件
 * 右键resources包名——>新建file——>输入属性文件名：config.properties
 * 右键resources包名——>新建Resource Bundle——>在弹出的对话框中输入属性文件名：config，不需要输入扩展名，默认就是properties
 * 2.在属性文件中是以键值对的形式存储属性，一般使用等号分隔键值
 * 属性文件中的属性一般都是英文，如果需要使用中文，需要设置属性文件编码与当前环境编码一致
 */
public class Test05Properties {
    public static void main(String[] args) throws IOException {
        //1)创建Properties对象
        Properties properties = new Properties();

        //2)通过当前类的字节码的类加载器,在当前程序与属性文件 之间建立流通道
        InputStream inputStream = Test05Properties.class.getClassLoader().getResourceAsStream("resources/config.properties");

        //3)加载属性文件调用Properties对象的load(InputStream)方法，如果这一行出现了异常，说明第2步中的属性文件路径不正确
        properties.load(inputStream);

        //4)读取属性
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("国籍"));  //出现乱码,说明属性文件编码与当前环境编码不兼容
        System.out.println(properties.getProperty("country"));  //null,属性名不正确

        //5)关闭流通道
        if (inputStream != null) {
            inputStream.close();
        }

    }
}