package com.bjpowernode.exceptions;

public class Test08 {
    public static void main(String[] args) {
        Test08Person p = new Test08Person();
        p.setName("zhangsan");
        //调用setAge方法,如果年龄超出人的合理范围就会抛出异常
        p.setAge(22);
        //调用setGender方法时, 需要对该方法的编译异常进行预处理
        try {
            p.setGender("妖");
        } catch (Test08IllegalGenderException e) {
            e.printStackTrace();
        }
        System.out.println(p);
    }
}