package com.powernode.map.hash;

import java.util.Properties;

public class Test03Properties {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("username", "powernode");
        properties.setProperty("password", "8888");
        properties.put("country", "china");

        //读取属性
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("country"));
        System.out.println(properties.get("username"));

        //读取某一个系统属性
        String userDir = System.getProperty("user.dir");    //用户目录, 属性名user.dir是系统定义的
        System.out.println(userDir);

        //获得所有 的系统属性
        Properties allProperties = System.getProperties();
        allProperties.forEach((k, v) -> System.out.println(k + " : " + v));

    }
}