package com.powernode.wrapper;

public class Test03Wrapper {
    public static void main(String[] args) {
        //自动装箱
        Integer i1 = 123;       //i1是Integer类定义的对象名, 不能直接把整数 123 赋值给i1, 这儿隐含自动装箱 , 系统会根据整数123创建一个Integer对象, 把这个对象的引用赋值给i1

        //自动拆箱
        int num = i1;   //不能直接把i1变量的值赋值给num, 隐含自动拆箱, 系统 会调用i1对象的intValue()方法把对对象的value属性值赋值给num

        //大多数情况下,基本类型数据与包装类对象可以混用
        Integer i2 = 123;
        if (i1 > i2) {     //i1,i2是对象名, 不能直接使用>比较大小, 这儿隐含自动拆箱
            System.out.println("i1 > i2");
        }
        //想调用i1对象的实例方法时, 不能通过 整数 456 来调用

        /* 面试题
         *
         * java认为 -128~127 范围内的整数使用最频繁, 为了减少对象创建的数量,采用享元模式,
         * 这个范围内的整数自动装箱后, 保存在缓存(共享池)中, 类似于字符串字面量保存在字符串常量池中。
         * 即i1, i2两个对象名其实引用了缓存中同一个value值为123的Integer对象
         */
        System.out.println(i1 == i2);     //true

        Integer i3 = Integer.valueOf(123);
        System.out.println(i1 == i3);     //true

        Integer i4 = Integer.valueOf("123");
        System.out.println(i1 == i4);     //true

        Integer i5 = Integer.valueOf(1230);
        Integer i6 = Integer.valueOf(1230);
        System.out.println(i5 == i6);       //false，因为1230超出了享元的范围

        Integer i7 = new Integer(123);
        System.out.println(i1 == i7);     //false，因为使用了new创建了一个新的对象
    }
}