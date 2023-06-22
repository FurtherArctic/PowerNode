package com.powernode.map.hash;

import java.util.*;

public class Test08MapValue {
    public static void main(String[] args) {
        //有网址
        String urlText = "https://www.baihe.com/register?name=yang&age=58&hobby=smoking&hobby=drinking&hobby=girl";

        /*在URL地址中, 问号后面的是url参数, 参数是以键值对的形式存在的, 参数之间使用&连接符连接,上面url地址中的参数信息
                参数名     参数值
                name      yang
                age       58
                hobby     smoking
                hobby     drinking
                hobby     girl
            需求:
                把<参数名, 参数值> 保存到Map集合中
                hobby参数的值可能有多个, 在定义Map集合时, Map的键保存参数名可以定义为String字符串类型,  Map的value值保存参数的值, 有的参数值包含多个, Map的value值可以定义为数组, Collection集合等容器
         */
        Map<String, List<String>> map = new HashMap<>();

        //在URL地址中,问号后面的是参数信息, 先确定问号的位置
        int question = urlText.indexOf("?");
        //把问号后面的参数字符串取出来
        String paramStr = urlText.substring(question + 1);
        System.out.println(paramStr);     //name=yang&age=58&hobby=smoking&hobby=drinking&hobby=girl
        //参数字符串中,参数之间使用&连接符分隔, 就使用&对参数字符串进行拆分
        String[] paramArray = paramStr.split("&");
        System.out.println(Arrays.toString(paramArray));
        for (String param : paramArray) {
            System.out.println(param);      //name=yang     age=58      hobby=smoking       hobby=drinking      hobby=girl
            //param参数名与参数值之间使用等号=连接, 再使用=对param字符串进行二次拆分
            String[] split = param.split("=");  //[name, yang]   [age,  58]     [hobby, smoking]   [bobby, drinking ]
            System.out.println(Arrays.toString(split));
            //split[0]数组元素是参数名,   split[1]数组元素是参数值
            //如果map的键不包含 split[0] 参数名, 向map集合中添加数据
            if (!map.containsKey(split[0])) {
                //先创建一个存储参数值的List集合
                List<String> list = new ArrayList<>();
                //把split[1]参数值添加到list集合中
                list.add(split[1]);
                //把<参数名, 保存参数值的List集合> 添加到map中
                map.put(split[0], list);
            } else {
                //从map集合中把保存split[0]参数值的List集合取出来
                List<String> list = map.get(split[0]);
                //把split[1] 参数值也添加到这个list集合中
                list.add(split[1]);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "参数的值为: " + entry.getValue());
        }
    }
}