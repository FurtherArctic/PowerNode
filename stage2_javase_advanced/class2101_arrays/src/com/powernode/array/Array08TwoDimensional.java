package com.powernode.array;

import java.util.Arrays;

public class Array08TwoDimensional {

    public static void main(String[] args) {
        int[] array1 = new int[12];
        int[] array2 = {1, 2, 3, 4};
        int[] array3 = {323, 3, 16, 54, 87, 43};

        int[][] arrays1 = {array1, array2, array3};
        int[][] arrays2 = new int[5][3];
        for (int[] ints : arrays2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


        arrays2[0] = array1;
        arrays2[1] = array2;
        arrays2[2] = array3;

        arrays2[0][5] = 12;
        for (int i = 0; i < arrays2.length; i++) {
            System.out.println(Arrays.toString(arrays2[i]));
        }
    }

}