package com.powernode.wrapper;

public class Test02Method {
    public static void main(String[] args) {
        //1) byteValue(), intValue()...可以把包装类对象转换为基本类型数据
        //所有包装类底层都有一个value属性,存储对应的基本类型数据,  byteValue(), intValue()其实就是返回这个value属性值
        Integer i1 = new Integer(456);      //把整数456赋值给i1对象的value属性
        int num = i1.intValue();
        Double d1 = new Double(45.78);  //把小数45.78赋值给d1对象的value属性
        double dd = d1.doubleValue();

        //2) static int compare(int x, int y)  比较两个基本类型数据的大小,如果第一个数大返回正数,相等返回0, 第一个数小返回负数
        System.out.println(Integer.compare(10, 20));        //-1
        System.out.println(Double.compare(3.1, 2.8));      //1
        System.out.println(Boolean.compare(false, false));  //0
        System.out.println(Boolean.compare(true, false));  //1

        //3) 所有 包装类都实现了Comparable接口,重写了compareTo抽象方法比较两个包装类对象的大小, 其实比较的是value属性值的大小
        Integer i2 = new Integer("123");
        System.out.println(i1.compareTo(i2)); //比较i1对象的value属性值456 与 i2对象的value属性值123的大小

        //4) 除了Character外,其他包装类都有 parseXXX(xxx)方法可以把字符串转换为基本类型数据
        num = Integer.parseInt("2343");
        dd = Double.parseDouble("123.34");
        boolean flag = Boolean.parseBoolean("helll");

        //5 从JDK9开始 ,不建议通过构造方法创建包装类对象了, 建议调用静态方法valueOf()创建包装类对象
        Integer i3 = Integer.valueOf(789);
        Double d3 = Double.valueOf("23.54");
        Boolean b3 = Boolean.valueOf("True");
        Character c3 = Character.valueOf('A');

    }
}