package com.powernode.date;

import java.util.Calendar;

public class Test02Calendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        //Calendar常用实例方法 get( 字段  ) 返回指定的字段值
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));    //8, 月份是从0开始的, 数字8表示9月
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR));     //12小时制
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));  //24小时制
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
    }
}