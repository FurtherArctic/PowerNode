package com.powernode.array;

import java.util.Arrays;

public class Array07Comparable {
    public static void main(String[] args) {
        Person[] persons = new Person[50];
        int size = 0;

        persons[size++] = new Person("John", 23);
        persons[size++] = new Person("James", 54);
        persons[size++] = new Person("Bob", 24);
        persons[size++] = new Person("Fox", 15);
        persons[size++] = new Person("Alice", 43);
        persons[size++] = new Person("Kate", 26);
        persons[size++] = new Person("Lucy", 26);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(persons[i].name + "," + persons[i].age);
        }
        Arrays.sort(persons, 0, size);

        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.println(persons[i].name + "," + persons[i].age);
        }
    }

    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        /**
         * 重写Comparable中的compareTo方法，在此方法中定义比较规则。
         * 两个Person对象比较大小，p1.compareTo(p2)，在此方法的方法体中this对象表示p1，参数o表示p2
         *
         * @param o the object to be compared.
         * @return int
         */
        @Override
        public int compareTo(Person o) {
            if (this.age > o.age) {
                return 1;
            } else if (this.age < o.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}