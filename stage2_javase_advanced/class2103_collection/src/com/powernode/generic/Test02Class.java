package com.powernode.generic;

import java.util.Date;

public class Test02Class {
    public static void main(String[] args) {
        //在使用泛型类时，需要显示给泛型参数T传递数据类型
        GenericClass<String> obj1 = new GenericClass<>();
        obj1.setData("hello");
        String s = obj1.getData();
        System.out.println(s);

        GenericClass<Date> obj2 = new GenericClass<>();
        obj2.setData(new Date());
        Date date = obj2.getData();
        System.out.println(date);

        //如果在使用泛型类时，不显示给泛型参数T传递数据类型，则系统默认给T传递Object类型
        GenericClass obj3 = new GenericClass();
        Object data = obj3.getData();
        System.out.println(data);
    }
}

/**
 * 定义类时, 在类名/接口名后面使用<T>声明泛型参数
 *
 * @param <T>
 */
class GenericClass<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}