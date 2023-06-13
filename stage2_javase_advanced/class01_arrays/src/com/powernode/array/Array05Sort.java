package com.powernode.array;

import java.util.Arrays;

public class Array05Sort {
    public static void main(String[] args) {
        int[] array = {1, 43, 21, 11, 3423, 44, 5324, 23, 533, 5};
        System.out.println(Arrays.toString(array));
        bubblingSorting(array);
//        System.out.println(Arrays.toString(array));
//        selectSort(array);
        System.out.println(Arrays.toString(array));

        find(array, 5555);
        find(array, 23);

    }

    private static void find(int[] array, int key) {
        int begin = 0;
        int end = array.length - 1;
        int mid = (begin + end) / 2;

        while (true) {
            if (key == array[mid]) {
                System.out.println(key + "在该数组中的索引值为：" + mid);
                break;
            } else if (key > array[mid]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (end + begin) / 2;
            if (begin > end) {
                System.out.println(key + "在该数组中存在：" + (-1));
                break;
            }
        }
    }

    private static void selectSort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            //假设索引值为j的元素为最小元素，获取其索引值
            int min = array[j];
            int index = j;
            //循环依次将array[j]与其他元素比较，其他元素大于min时，将min的值修改为该数据，并更新索引值
            for (int i = j; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    index = i;
                }
            }
            //将找到的最小值与第array[j]交换
            int temp = array[j];
            array[j] = min;
            array[index] = temp;
        }
    }

    private static void bubblingSorting(int[] array) {
        //使用嵌套for循环，外层循环表示比较的轮数，其值为array.length-1
        for (int i = 1; i < array.length; i++) {
            //内层循环比较元素大小并排序，第i轮需要比较length - i个元素
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}