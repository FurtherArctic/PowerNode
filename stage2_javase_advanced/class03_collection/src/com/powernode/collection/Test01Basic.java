package com.powernode.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Test01Basic {
    public static void main(String[] args) {
        //1 创建集合, Collection是一个接口,需要赋值实现类对象, 再通过接口引用调用抽象方法时,实际执行的是实现类对象的方法,这是多态
        Collection collection = new ArrayList();
        Collection<String> collection2 = new LinkedList<>();
        Collection collection1 = new HashSet();

        //2 添加数据调用 add()方法
        collection.add(new Object());
        collection.add("hello");
        collection.add("world");
        collection.add("hello");
        //添加整数时,隐含自动装箱
        collection.add(456);  //系统先根据整数 456 创建一个Integer对象, 再把这个对象添加到集合中
        collection.add(789);

        collection2.add("Apple");
        //collection2.add(12);

        //直接打印collection, 会调用collection引用 的LinkedList对象的toString()方法
        System.out.println(collection);
        //[java.lang.Object@4554617c, hello, world, hello, 456, 789]

        //3) 判断
        System.out.println(collection.size());    //6,  集合中元素的数量
        System.out.println(collection.isEmpty());     //false, 不是空集合
        System.out.println(collection.contains("hello"));   //true, 集合中包含"hello"元素

        //4) 删除, remove(object o )从集合中删除第一个与o匹配的元素,删除成功返回true
        boolean flag = collection.remove("hello");
        System.out.println(flag);     //true, 删除成功
        System.out.println(collection);
        //[java.lang.Object@4554617c, world, hello, 456, 789]

        //5 foreach遍历
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}