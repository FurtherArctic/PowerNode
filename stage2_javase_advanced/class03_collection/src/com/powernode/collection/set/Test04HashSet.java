package com.powernode.collection.set;

import java.util.HashSet;
import java.util.Objects;

public class Test04HashSet {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (age != student.age) return false;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }
    }
}