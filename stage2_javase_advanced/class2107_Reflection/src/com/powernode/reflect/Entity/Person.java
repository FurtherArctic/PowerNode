package com.powernode.reflect.Entity;

public class Person {
    public String name;
    private int age;

    static {
        System.out.println("Person类的静态代码块");
    }

    public Person() {
        System.out.println("Person类的无参构造方法");
    }

    public Person(String name, int age) {
        System.out.println("Person类有两个参数的构造方法");
        this.name = name;
        this.age = age;
    }

    public void setData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
