package com.powernode.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class Test05TreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            /**
             *
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return 降序
             */
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("good");
        treeSet.add("nice");
        treeSet.add("boy");
        treeSet.add("girl");
        System.out.println(treeSet);

        /*
         * 如果调用TreeSet()无参构造方法，没有在构造方法指定Comparator，要求集合中元素本身具有比较大小的能力。
         * 如果在TreeSet集合中存储String字符串，String类已经实现了Comparable接口，即String对象本身具有了比较大小的功能
         * str1.compareTo(str2)比较时，如果前面第一个字符串大返回正数，对应升序排序
         */
        TreeSet<String> treeSet2 = new TreeSet<>();
        treeSet2.addAll(treeSet);  //把treeSet集合中所有的元素都添加到treeSet集合中
        System.out.println(treeSet2);
    }
}