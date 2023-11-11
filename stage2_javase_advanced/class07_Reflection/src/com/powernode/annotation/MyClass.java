package com.powernode.annotation;

/**
 * 使用自定义注解
 *
 * @author wangjunchen
 */
@MyAnnotation("controller")
public class MyClass {
    @MyAnnotation("method")
    public static void m1() {
        System.out.println("MyClass类的静态方法");
    }
}
