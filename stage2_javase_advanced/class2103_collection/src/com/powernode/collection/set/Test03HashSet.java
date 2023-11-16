package com.powernode.collection.set;

import java.util.HashSet;

public class Test03HashSet {
    public static void main(String[] args) {
        HashSet<Student> hashSet = new HashSet<>();

        System.out.println(hashSet.add(new Student("zhangsan", 23)));
        System.out.println(hashSet.add(new Student("zhangsan", 23)));
        System.out.println(hashSet.add(new Student("zhangsan", 23)));

        System.out.println(hashSet);
    }

    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}