package com.powernode.wrapper;

public class Test01Construct {
    public static void main(String[] args) {
        //1 所有包装类都可以根据基本类型数据创建对象
        Byte b1 = new Byte((byte) 100);
        Short s1 = new Short((short) 123);
        Integer i1 = new Integer(789);
        Long g1 = new Long(456789L);
        Float f1 = new Float(45.7);
        Double d1 = new Double(12.45);
        Character c1 = new Character('A');
        Boolean n1 = new Boolean(true);

        //2 除了Character 外, 其他包装类可以根据String字符串创建对象
        Byte b2 = new Byte("45");
        Integer i2 = new Integer("23445");
        Double d2 = new Double("23.45");
        //注意: 字符串要符合对应数字格式
        //Byte b3 = new Byte("456");      //NumberFormatException
        //Integer i3 = new Integer("hehe");   //NumberFormatException
        //Boolean会把非true的字符串都转换为false
        Boolean n3 = new Boolean("Good");
        System.out.println(n3);       //false

        //3 包装类的字段
        System.out.println(Integer.MAX_VALUE);      //2147483647
        System.out.println(Integer.MIN_VALUE);      //-2147483648

        System.out.println(Double.POSITIVE_INFINITY);     //正无穷大
        System.out.println(Double.NEGATIVE_INFINITY);      //负无穷大
        System.out.println(Double.NaN);
        System.out.println(10 / 0);   //ArithmeticException算术异常，整数相除，除数不能为0
        System.out.println(5.6 / 0);      //Infinity, 无穷大
        System.out.println(-5.6 / 0);     //-Infinity
        System.out.println(0.0 / 0);      //NaN, Not a number

    }
}