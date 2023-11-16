package com.powernode.array;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        //数组赋值并遍历
        //doubleArrays();
        //数组逆序输出
        //reverse();
        //找到数组最大值
        //findMax();
        //前面数据之和与后面数据之和相等
        //sum();

        //outOfOrder();


        int[] array = {1, 1, 2, 6, 8, 0, 34, 0, 2, 15, 1};
        int sumLeft = 0;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            int sumRight = 0;
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }
            sumRight -= array[i + 1];
            if (sumLeft == sumRight) {
                System.out.println(i + 1);
                count++;
            }
        }
        if (count == 0) {
            System.out.println(-1);
        }
    }

    private static void outOfOrder() {
        int[] array = {1, 43, 2, 5443, 564, 673, 8, 66, 78};
        for (int i = 0; i < array.length; i++) {
            int x = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[x];
            array[x] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void sum() {
        int[] array = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);
        int avg = sum / 2;
        int sum2 = 0;
        for (int i = 0; i < array.length; i++) {
            sum2 += array[i];
            if (sum2 == avg) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void findMax() {
        int[] intArray = {134, 524, 324231, 212665646, 3213, 43, 666, 432};
        int max = intArray[0];
        int index = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
                index = i;
            }
        }
        System.out.println("intArray数组中的最大值为：" + max + "，其索引值为：" + index);
    }

    private static void reverse() {
        int[] intArray = {134, 524, 324231, 212, 3213, 43, 666, 432};
        int[] reverseArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            reverseArray[intArray.length - i - 1] = intArray[i];
        }
        System.out.println("逆序前的数组为：" + Arrays.toString(intArray));
        System.out.println("逆序后的数组为：" + Arrays.toString(reverseArray));
    }

    private static void doubleArrays() {
        double[] array = new double[12];
        for (int i = 0; i < array.length; i++) {
            double d = Math.random();
            array[i] = d;
        }

        for (double d : array
        ) {
            System.out.println(d);
        }
    }
}