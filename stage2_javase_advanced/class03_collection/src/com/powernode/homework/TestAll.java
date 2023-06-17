package com.powernode.homework;

public class TestAll {
    public static void main(String[] args) {
        Student student2 = new Student("apple", 65, 23);
        Student student1 = new Student("apple", 65, 23);
        System.out.println(student1.equals(student2));
    }
}