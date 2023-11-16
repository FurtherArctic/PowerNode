package com.powernode.map.hash;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test02Customization {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>();

        map.put(1, new Student("zhangsan", 80));
        map.put(2, new Student("lisi", 90));
        map.put(3, new Student("wangwu", 40));
        map.put(4, new Student("zhaoliu", 50));
        map.put(5, new Student("chenqi", 87));
        map.put(6, new Student("zhuba", 20));
        map.put(7, new Student("zhouyi", 60));
        map.put(8, new Student("haner", 90));
        map.put(9, new Student("feifei", 40));

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(integer);
        }

        System.out.println(map.get(3));

        Student alice = map.replace(9, new Student("Alice", 76));
        System.out.println(alice);
        System.out.println(map.get(9));

        for (Map.Entry<Integer, Student> studentEntry : map.entrySet()) {
            //System.out.println(studentEntry);
            System.out.println("学生编号：" + studentEntry.getKey() + "，学生姓名：" + studentEntry.getValue().name + "，学生成绩：" + studentEntry.getValue().score);
        }
        System.out.println("================================================================");
        System.out.println(map);
        deleteByCollection(map);

        //系统会把map集合的每个Entry的键传递给方法的第一个参数,  把Entry的值传递给第二个参数
        map.forEach((integer, student) -> System.out.println(integer + " 编号的同学为: " + student));

        //System.out.println(map);
    }

    private static void deleteByCollection(Map<Integer, Student> map) {
        Collection<Student> values = map.values();
        values.removeIf(next -> next.score < 60);
    }

    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}