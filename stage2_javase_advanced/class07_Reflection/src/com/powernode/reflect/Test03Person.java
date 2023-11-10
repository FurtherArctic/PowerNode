package com.powernode.reflect;

import com.powernode.reflect.Entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射创建类的实例,访问字段,调用方法
 *
 * @author wangjunchen
 */
public class Test03Person {
    public static void main(String[] args) throws Exception {
        /*
         * class.forName("")方式创建Class对象时,JVM会把Person字节码加载到内存中,
         * 系统为这个类创建一个对应的Class对象,同时对类初始化,执行静态代码块.
         * 使用JDBC连接数据库时,就可以通过class.forName("com.mysql.cj.jdbc.Driver")
         * 注册驱动程序,因为在驱动程序类的静态代码块中实现了注册功能.
         */
        //Class<?> clazz1 = Class.forName("com.powernode.reflect.Entity.Person");
        /*
         * 如果通过下面的方式创建Class对象,会把Person.class加载到内存中,系统为这个Person类
         * 创建一个对应的Class对象,但是并没有对Person类初始化,因此不会执行静态代码块
         * 但是,任何一个类在使用时,都需要对类进行初始化,然后就一定会执行静态代码块.
         * 因此,之后在使用到Person类时,还是会对其初始化,同时执行静态代码块
         *
         * 当确定要反射某个具体类时,可以使用泛型
         */
        Class<Person> clazz2 = Person.class;

        //通过反射创建Person类的实例
        //1. 直接调用class对象的实例方法newInstance(),默认调用无参构造,此方法在JDK8及之前版本可用
        Person person1 = clazz2.newInstance();
        System.out.println(person1);
        //2. 先反射某个具体的构造方法，再通过构造方法创建类实例。
        // 调用Class对象的getDeclaredConstructor(形参列表)返回指定参数列表的构造方法，返回类型为Constructor
        Constructor<Person> declaredConstructor = clazz2.getDeclaredConstructor(String.class, int.class);
        //然后再用此Constructor对象调用newInstance()方法给参数赋值同时创建对象。
        Person person2 = declaredConstructor.newInstance("Mike", 12);
        System.out.println(person2);
        System.out.println("================================================");
        //通过反射访问字段
        //1. 反射字段,Class对象的getField("字段名")方法可以访问到当前类的public字段,getDeclaredField(字段名)可以访问所有字段,包含private字段
        Field name1 = clazz2.getField("name");
        Field name2 = clazz2.getDeclaredField("name");
        Field age = clazz2.getDeclaredField("age");
        //2. 访问字段,Field对象的set(实例名,字段值)方法可以设置指定实例对象的字段值
        name1.setAccessible(false);
        name1.set(person1, "Apple");
        name1.set(person2, "Google");
        age.setAccessible(true);
        age.set(person1, 29);
        age.set(person2, 43);

        //调用Field对象的get(实例名)方法返回指定对象字段值
        Object o1 = name1.get(person1);
        Object o2 = name1.get(person2);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(age.get(person1));
        System.out.println("================================================");
        //通过反射调用方法
        //1. 先反射方法，调用Class对象的getMethod(方法名,形参列表)返回指定签名的方法,无参方法可以省略
        Method setAge = clazz2.getMethod("setAge", int.class);
        Method setData = clazz2.getMethod("setData", String.class, int.class);
        Method getAge = clazz2.getMethod("getAge");

        //2. 调用Method对象的invoke(实例名,实参列表)方法可以执行Method方法
        setData.invoke(person1, "IBM", 32);
        setAge.invoke(person2, 234);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(getAge.invoke(person1));
    }
}
