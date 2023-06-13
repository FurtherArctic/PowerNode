package com.powernode.array;

public class Array01Basic {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = new int[3];
        int array3[] = {32};
        String[] array4 = new String[6];
        for (int i = 0; i < array4.length; i++) {
            System.out.println(array4[i] + " 数据String");
        }
        char[] array5 = new char[5];
        for (char arrays : array5
        ) {
            System.out.println(arrays + "   char");
        }
    }
}