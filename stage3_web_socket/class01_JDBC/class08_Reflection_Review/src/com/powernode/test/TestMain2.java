package com.powernode.test;

import com.powernode.entity.Student;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestMain2 {
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;

        Student student = studentClass.getConstructor().newInstance();
        Method sayHello = studentClass.getDeclaredMethod("sayHello", String.class, int.class);

        String sayHelloName = sayHello.getName();
        System.out.println("方法名称:" + sayHelloName);

        Class<?> returnType = sayHello.getReturnType();
        System.out.println("方法返回值类型:" + returnType);

        int parameterCount = sayHello.getParameterCount();
        System.out.println("方法参数个数:" + parameterCount);

        Class<?>[] parameterTypes = sayHello.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("方法参数类型:" + parameterType);
        }

        String s = Modifier.toString(sayHello.getModifiers());
        System.out.println("方法修饰符:" + s);


        sayHello.setAccessible(true);
        Object invoke = sayHello.invoke(student, "Mike!", 23);

        System.out.println(invoke);
    }
}
