package com.powernode.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射注解的信息
 */
public class Test02ReflectAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建class对象
        Class<MyClass> clazz = MyClass.class;

        //调用class对象的getAnnotation方法返回类的注解
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);

        //获取注解的值,注解不是必须的,所以先判断是否有注解
        if (annotation != null) {
            System.out.println(annotation.value());
        }

        //先获取类的方法
        Method m1 = clazz.getMethod("m1");
        //再反射方法的注解
        MyAnnotation m1Annotation = m1.getAnnotation(MyAnnotation.class);
        if (m1Annotation != null) {
            String value = m1Annotation.value();
            System.out.println(value);
            //方法注解的value属性是method,则调用此方法,静态方法调用时实例名参数传递为null
            if ("method".equals(value)) {
                m1.invoke(null);
            }
        }
    }
}
