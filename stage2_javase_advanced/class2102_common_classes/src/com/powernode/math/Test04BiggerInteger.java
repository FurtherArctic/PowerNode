package com.powernode.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Test04BiggerInteger {
    public static void main(String[] args) {
        //float, double小数采用近似值保存, 不准确
        System.out.println(2 - 1.1);      //0.8999999999999999

        //float有7位有效数字, double有15位有效数字
        BigInteger i1 = new BigInteger("79846579461534856123846513284561234865123486513256123");
        BigInteger i2 = new BigInteger("79486518946514896514856123485614856123845615614");
        //add() 相加,  subtract()相减, multiply()相乘, divide()相除
        BigInteger i3 = i1.add(i2);     //加
        System.out.println("i3 = " + i3);

        i3 = i1.subtract(i2);           //减
        System.out.println("i3 = " + i3);

        i3 = i1.multiply(i2);           //乘
        System.out.println("i3 = " + i3);

        i3 = i1.divide(i2);             //除
        System.out.println("i3 = " + i3);

        //注意: 小数相除,如果除不尽会产生算术异常ArithmeticException
        BigDecimal d1 = new BigDecimal("785456444564646464.48");
        BigDecimal d2 = new BigDecimal("789465465.48");
        //BigDecimal d3 = d1.divide(d2);      //ArithmeticException
        //小数相除, 通常调用divide( divisor除数,  scale小数位数, roundingMode尾数的处理方式)
        BigDecimal d3 = d1.divide(d2, 10, RoundingMode.FLOOR);
        System.out.println(d3);
    }
}