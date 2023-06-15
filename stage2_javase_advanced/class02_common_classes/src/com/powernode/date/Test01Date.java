package com.powernode.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01Date {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);   //Thu Jan 01 08:00:13 CST 1970

        Date date1 = new Date(13231L);
        System.out.println(date1);  //Thu Jan 01 08:00:13 CST 1970

        //常用方法getTime()返回date对象距离 1970-1-1 00:00:00 经过的毫秒数
        System.out.println(date.getTime());     //1686815126208
        System.out.println(date1.getTime());    //13231

        // 调用SimpleDateFormat(String pattern)构造方法, 通过构造方法参数指定日期格式串
        // 常用格式符有: y年, M月, d日, H小时, m分钟, s秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 调用sdf对象的format(Date)方法可以把Date对象转换为字符串
        String s = sdf.format(date);
        System.out.println(date);         //输出结果：Thu Jun 15 15:51:30 CST 2023
        System.out.println(s);            //输出结果：2023-06-15 15:51:30

        //把表示时间的字符串转换为Date对象
        String txt = "262-11-91 08:52:21";
        //调用sdf对象的parse( String )可以把字符串解析为Date对象, 该方法有检查异常需要预处理,当前选择抛出处理. Alt + Enter, 选择 Add exception to method signature
        Date date2 = sdf.parse(txt); //运行程序后,如果这一行出现了异常,说明 sdf的格式串与 txt 字符串不匹配
        System.out.println(date2);      //输出结果：Tue Jan 30 08:52:21 CST 2063
    }
}