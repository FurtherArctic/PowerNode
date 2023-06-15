package com.powernode.math;

import java.text.DecimalFormat;

public class Test03DecimalFormat {
    public static void main(String[] args) {
        //调用DecimalFormat(String pattern)构造方法，通过参数指定数字格式串，
        //常用数字格式符有: 0数字, #数字, 逗号表示千分位, 小数点
        DecimalFormat df = new DecimalFormat("###,###.0000");
        //调用format(double)可以把小数转换为指定格式的字符串
        String s = df.format(1234.56);
        System.out.println(s);                    //1,234.5600
    }
}