package com.powernode.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjunchen
 * 统计字符串中每个字符出现的次数, 把 <字符,次数> 保存到Map集合中
 */
public class CountTheNumberOfCharacters {
    public static void main(String[] args) {
        String str = "asaasddfasjgklajglhjsdlfkhjslghlahglhgfljkhaflksjldkjglkjlkfajdsljasl";

        //定义Map集合保存<字符,次数>
        Map<Character, Integer> map = new HashMap<>();

        //遍历字符串的每个字符
        for (int i = 0; i < str.length(); i++) {
            //如果map的键不包含字符cc, 说明字符cc是第一次出现
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                //map的键包含字符cc,从map集合中把cc之前出现的次数取出来
                Integer count = map.get(str.charAt(i));
                //修改map集合中cc的次数
                map.put(str.charAt(i), count + 1);
            }
        }

        System.out.println(map);
    }
}