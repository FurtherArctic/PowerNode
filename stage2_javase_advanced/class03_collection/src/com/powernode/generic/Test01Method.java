package com.powernode.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01Method {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        //在调用方法时, 不需要显示给方法泛型参数T传递数据类型, 系统会根据实参类型自动推断
        addAll(stringList, "hello", "world", "nice", "good");

        List<Integer> integerList = new ArrayList<>();
        addAll(integerList, 6, 4, 87, 32, 65, 87, 90, 324, 231);
    }

    /*
     * 定义方法，可以向list集合同时添加若干个数据，该方法需要通过参数接收一个List集合，通过参数接收若干数据。
     * 第二个参数接收若干数据时，可以定义为变长参数，参数类型要与List集合存储元素的类型一致。
     * 当前方法List集合可以存储各种类型的数据，第二个变长参数的类型只要与List集合存储元素的类型一致即可，
     * 即不管List集合存储哪种类型的数据，都可以向集合中添加若干元素，
     * 元素的类型是可变的，可以使用泛型接收List集合元素的类型和变长参数的类型
     * 在方法返回值类型前面使用<T>声明泛型参数，List集合存储T类型的数据，变长参数就是T类型
     */
    @SafeVarargs
    private static <T> void addAll(List<T> list, T... data) {
        //在方法体中,把变长参数接收的数据添加到list集合中
        list.addAll(Arrays.asList(data));
    }
}