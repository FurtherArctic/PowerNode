package com.powernode.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test03LocalDateTime {
    public static void main(String[] args) {
        //创建LocalDateTime对象, LocalDateTime类构造方法是private私有的, 不能直接new对象, 该类提供了静态方法now()返回本类 对象
        //LocalDateTime localDateTime = new LocalDateTime();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //调用 LocalDateTime 的实例方法format( DateTimeFormatter) 可以把LocalDateTime对象转换为字符串,通过format参数 DateTimeFormatter 指定日期格式
        //调用 DateTimeFormatter的静态方法ofPattern()创建DateTimeFormatter 对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String s = localDateTime.format(dtf);
        System.out.println(s);        //2022年09月29日 09:26:24

        //把字符串解析为对象
        String str = "2033年11月29日 09:26:24";
        //调用LocalDateTime类的静态方法 parse( CharSequence , DateTimeFormatter)可以把字符串解析为对象
        localDateTime = LocalDateTime.parse(str, dtf);  //如果这一行出现了异常,说明 str字符串 与 dtf 格式不匹配
        System.out.println(localDateTime);

        //获得日期的字段值
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());     //NOVEMBER
        System.out.println(localDateTime.getMonthValue());    //11
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
    }
}