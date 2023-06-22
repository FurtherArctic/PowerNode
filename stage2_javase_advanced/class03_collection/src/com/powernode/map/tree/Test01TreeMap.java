package com.powernode.map.tree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Test01TreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap1 = new TreeMap<>(Comparator.reverseOrder());
        treeMap1.put("chenqi", 80);
        treeMap1.put("wangwu", 70);
        treeMap1.put("zhaosi", 90);
        treeMap1.put("hanyi", 50);
        treeMap1.put("liusan", 60);
        treeMap1.put("sunjiu", 70);

        treeMap1.forEach((s, integer) -> System.out.println("Key: " + s + ", value: " + integer));

        TreeMap<String, Integer> treeMap2 = new TreeMap<>();
        treeMap2.putAll(treeMap1);

        System.out.println("================================================================");
        System.out.println(treeMap2);
        Map.Entry<String, Integer> firstEntry = treeMap2.firstEntry();
        System.out.println(firstEntry);
        Map.Entry<String, Integer> lastEntry1 = treeMap2.lastEntry();
        System.out.println(lastEntry1);
        String s = treeMap2.firstKey();
        System.out.println(s);
        String lastKey = treeMap2.lastKey();
        System.out.println(lastKey);
        Map.Entry<String, Integer> stringIntegerEntry1 = treeMap2.pollFirstEntry();
        System.out.println(stringIntegerEntry1);
        Map.Entry<String, Integer> lastEntry = treeMap2.pollLastEntry();
        System.out.println(lastEntry);

    }
}