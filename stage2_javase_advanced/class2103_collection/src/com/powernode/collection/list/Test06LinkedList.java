package com.powernode.collection.list;

import java.util.LinkedList;

public class Test06LinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        //添加
        linkedList.add("Apple");
        linkedList.add("IBM");
        linkedList.add("Microsoft");
        linkedList.add("Facebook");
        linkedList.add("Google");
        linkedList.add("Microsoft");
        System.out.println(linkedList);

        //删除
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.remove("Microsoft");
        System.out.println(linkedList);



    }
}