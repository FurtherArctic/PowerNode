package com.powernode.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Test03Wrapper {
    public static void main(String[] args) {
        //创建Collection集合存储 整数
        Collection<Integer> collection = new ArrayList<>();

        //向集合中添加20个[0,100)范围内的随机整数
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            collection.add(random.nextInt(100));    //隐含自动装箱
        }
        System.out.println(collection);

        //判断是否包含66
        System.out.println(collection.contains(66));       //隐含自动装箱

        //删除所有小于50的整数
        for (Iterator<Integer> iterator = collection.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if (next < 50) {       //隐含自动拆箱
                iterator.remove();
            }
        }

        //foreach遍历
        for (Integer integer : collection) {
            System.out.print(integer + "  ");
        }
        System.out.println();
    }
}