package com.powernode.collection.set;

import java.util.*;

public class Test01Basic {
    public static void main(String[] args) {
        //定义Set集合存储String字符串, 通过泛型指定元素的类型, Set接口赋值实现类对象
        Set<String> set = new HashSet<>();

        set.add("bjpowernode");
        set.add("hello");
        set.add("world");
        set.add("boy");
        set.add("hello");
        set.add("girl");

        //Set集合元素的存储顺序与添加顺序可能不一样, 不允许存储重复的数据
        System.out.println(set);
        //[world, hello, girl, boy, bjpowernode]

        System.out.println(set.size());   //5
        System.out.println(set.contains("boy"));   //true

        set.remove("hello");
        System.out.println(set);      //[world, girl, boy, bjpowernode]

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if (next.length() < 5) {
                iterator.remove();
            }
        }

        for (String s : set) {
            System.out.print(s + "   ");
        }
        System.out.println();
        System.out.println("================================================");

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        while (list.size() < 20) {
            Integer i = random.nextInt(100);
            if (!list.contains(i)) {
                list.add(i);
            }
        }

        System.out.println(list);
        System.out.println(list.size());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
        System.out.println("===============================================");

        Set<Integer> set1 = new HashSet<>();
        while (set1.size() < 20) {
            Integer num = random.nextInt(100);
            set1.add(num);
        }

        System.out.println(set1);
        System.out.println(set1.size());
    }
}