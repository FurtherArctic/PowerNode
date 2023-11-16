package com.powernode.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangjunchen
 * <p>
 * Collections类的常用方法
 */
public class Test01Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //addAll()向集合 中同时添加若干数据
        Collections.addAll(list, "xx", "hh", "mm", "aa", "ww", "dd");
        System.out.println(list);

        //sort(List)对list排序
        Collections.sort(list);     //要求list集合中的元素本身 具有 比较大小 的功能
        System.out.println(list);

        //shuffle(List)对list集合乱序
        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
        System.out.println(list);

        //synchronizedXXX(xx)把不是线程安全的集合转换为线程安全的
        List<String> synchronizedList = Collections.synchronizedList(list);
        //现在 synchronizedList 集合就是线程安全的
    }
}