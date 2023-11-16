package com.powernode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * @author wangjunchen
 * <p>
 * 反射获取类的信息
 */

public class Test02ReflectInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        //0. 读取属性文件中的类名
        ResourceBundle bundle = ResourceBundle.getBundle("resources/config");
        String classname = bundle.getString("classname");

        //1. 根据类名获取Class对象
        Class<?> clazz = Class.forName(classname);


        //2. 通过反射获取类的声明
        //2.1 获取类的修饰符
        int mod = clazz.getModifiers();
        String s = Modifier.toString(mod);
        System.out.println(s);

        //2.2 获取类名
        //获取全限定类名
        String clazzName = clazz.getName();
        System.out.println(clazzName);
        //获取简单类名
        String clazzSimpleName = clazz.getSimpleName();
        System.out.println(clazzSimpleName);

        //2.3 获取父类名
        Class<?> clazzSuperclass = clazz.getSuperclass();
        System.out.println(clazzSuperclass.getName());
        System.out.println(clazzSuperclass.getSimpleName());

        //2.4 获取类实现的接口
        Class<?>[] clazzInterfaces = clazz.getInterfaces();
        for (Class<?> clazzInterface : clazzInterfaces) {
            System.out.print(clazzInterface.getSimpleName() + "-----");
        }
        System.out.println();
        System.out.println("======获取当前类及其父类中的public字段=================");
        //3. 通过反射获取类中的字段
        //getFields()方法可以获取当前类及其继承自父类的public字段的数组
        Field[] clazzFields = clazz.getFields();
        for (Field clazzField : clazzFields) {
            System.out.print(clazzField + "----");
        }
        System.out.println();
        System.out.println("============获取当前类中的所有字段,包含私有==============");

        //getDeclaredFields()可以获取当前类中的所有字段,包括私有字段,不包含继承自父类的字段
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            System.out.println("字段修饰符:" + Modifier.toString(declaredField.getModifiers()));
            System.out.println("字段类型:" + declaredField.getType().getSimpleName());
            System.out.println("字段名称:" + declaredField.getName());
            System.out.println("--------------------------------");
        }
        System.out.println("=====获取当前类及其父类的所有public方法=============");
        //4. 通过反射获取类中的方法
        //返回public修饰的公共方法，包括从父类继承的公共方法
        Method[] methods = clazz.getMethods();
        getMethodInfo(methods);

        System.out.println("=======获取当前类所有方法==============");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        getMethodInfo(declaredMethods);

        System.out.println("=======获取当前类中的所有构造方法==============");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }

    public static void getMethodInfo(Method[] methods) {
        System.out.println("总计有" + methods.length + "个方法");
        for (Method method : methods) {
            System.out.println("方法修饰符:" + Modifier.toString(method.getModifiers()));
            System.out.println("方法返回值:" + method.getReturnType().getSimpleName());
            System.out.println("方法名称:" + method.getName());
            System.out.println("方法参数类型:" + Arrays.toString(method.getParameterTypes()));
            System.out.println("方法参数个数:" + method.getParameterCount());
            System.out.println("------------------------");
        }
    }
}
