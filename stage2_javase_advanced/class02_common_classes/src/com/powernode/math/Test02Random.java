package com.powernode.math;

import java.util.Random;

public class Test02Random {
    public static void main(String[] args) {

        //创建Random对象
        Random random = new Random();
        //生成[0,1)范围内的随机小数
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextDouble());
        }
        //生成随机整数
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt());
        }
        //生成[0, limit)范围内的随机整数
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(30));
        }
    }
}