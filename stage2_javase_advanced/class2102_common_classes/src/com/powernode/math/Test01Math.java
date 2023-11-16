package com.powernode.math;

public class Test01Math {
    public static void main(String[] args) {
        //random()生成随机小数
        for (int i = 0; i < 5; i++) {
            System.out.println(Math.random());
        }

        System.out.println(Math.min(12.5, 45.8));  //返回两个数较小的
        System.out.println(Math.max(10, 5));       //返回两个数较大的

        //ceil(x)返回大于等于x最小整数, floor(x)返回小于等于x的最大整数
        System.out.println(Math.ceil(3.14));     //4.0
        System.out.println(Math.ceil(-3.14));     //-3.0
        System.out.println(Math.floor(-9.8));     //-10.0
        System.out.println(Math.floor(9.8));      //9.0

        //round(x)四舍五入, 其实是把 x加0.5后, 向下取整
        System.out.println(Math.round(3.5));   //4
        System.out.println(Math.round(3.9));   //4
        System.out.println(Math.round(-3.9));   //-4
        System.out.println(Math.round(-3.5));   //-3
    }
}