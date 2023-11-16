package com.powernode.map.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test01Lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Google");
        list.add("Facebook");
        list.add("Twitter");
        list.add("Microsoft");
        list.add("Apple");
        list.add("Oracle");

        System.out.println(list);

        //不使用Lambda表达式
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);

        //使用Lambda表达式
        list.sort((o1, o2) -> o2.compareTo(o1));

        System.out.println(list);

        list.forEach(System.out::println);
    }
}