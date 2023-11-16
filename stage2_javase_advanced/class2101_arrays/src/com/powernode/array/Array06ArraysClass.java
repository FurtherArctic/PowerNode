package com.powernode.array;

import java.util.Arrays;

public class Array06ArraysClass {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};

        int[] copyOf = Arrays.copyOf(array, 8);
        System.out.println(Arrays.toString(copyOf));

        int[] copyOfRange = Arrays.copyOfRange(array, 0, 1);
        System.out.println(Arrays.toString(copyOfRange));

        Arrays.fill(array, 1, 3, 344);
        System.out.println(Arrays.toString(array));

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.binarySearch(array, 34));
    }
}