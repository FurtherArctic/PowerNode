package com.powernode.collection.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test05List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("Apple");
        list.add("Oracle");
        list.add("IBM");
        list.add("Microsoft");
        list.add("Google");

        System.out.println(list);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("Apple"));
        System.out.println(list.contains("Apple1"));

        System.out.println("================================================");
        for (String next : list) {
            System.out.println(next);
        }

        System.out.println("================================================");
        list.add(5, "Twitter");
        list.add(6, "Twitter2");
        list.add(7, "Twitter3");
        list.add(8, "Twitter4");


        System.out.println(list);
        System.out.println(list.get(6));
        //System.out.println(list.remove(1));
        System.out.println(list);

        System.out.println(list.indexOf("Facebook"));
        System.out.println(list.lastIndexOf("Facebook"));

        System.out.println("================================================");

        List<String> subList = list.subList(2, 7);
        System.out.println(list);
        System.out.println(subList);
        System.out.println(subList.remove(0));
        System.out.println(list);

        System.out.println("================================================");
        System.out.println(list);

        list.clear();
        //匿名内部类
        list.sort(new Comparator<String>() {
            //排序规则：o1>o2方法返回负数, o1=o2方法返回0, o1<o2方法返回正数,在排序时对应降序
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);
        list.sort(new StringCmp());
        System.out.println(list);
    }

    //静态内部类
    static class StringCmp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            //排序规则：o1>o2方法返回正数, o1=o2方法返回0, o1<o2方法返回负数,在排序时对应升序
            return o1.compareTo(o2);
        }
    }
}