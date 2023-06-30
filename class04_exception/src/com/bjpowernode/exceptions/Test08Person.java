package com.bjpowernode.exceptions;

public class Test08Person {
    private String name;
    private int age;
    private String gender;

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
        if (age >= 0 && age < 130) {
            this.age = age;
        } else {
            //通过throw关键字抛出年龄越界异常
            throw new Test08AgeOutOfBoundsException(age + "超出人的合法年龄范围");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws Test08IllegalGenderException {
        if ("男".equals(gender) || "女".equals(gender)) {
            this.gender = gender;
        } else {
            //抛出非法性别异常, 通过throw抛出编译异常对象时, 当前方法需要通过throws声明它
            throw new Test08IllegalGenderException(gender + "不是合法性别");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}