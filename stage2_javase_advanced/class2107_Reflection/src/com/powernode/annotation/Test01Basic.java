package com.powernode.annotation;

import java.util.Comparator;
import java.util.Date;

public class Test01Basic {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Date date=new Date(2023, 1,23);
        System.out.println(date);

        Comparator<String> comparator= String::compareTo;
        System.out.println(comparator);
    }
}
