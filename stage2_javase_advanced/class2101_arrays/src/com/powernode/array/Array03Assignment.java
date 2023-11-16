package com.powernode.array;

public class Array03Assignment {
    public static void main(String[] args) {
        //初始化ints1
        int[] smallArray = {1, 2, 3, 4};
        int[] biggerArray = new int[smallArray.length * 2];
        System.arraycopy(smallArray, 1, biggerArray, 0, 3);
        for (int i : smallArray
        ) {
            System.out.println(i);

        }
        System.out.println();
        for (int i : biggerArray) {
            System.out.println(i);
        }

    }
}