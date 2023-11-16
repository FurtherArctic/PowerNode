package com.powernode.map.hash;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test01Basic {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //1) 调用put(k,v)向集合中添加键值对
        System.out.println(map.put("zhangsan", 80));
        map.put("lisi", 90);
        map.put("wangwu", 80);
        map.put("chenqi", 50);

        //2) 直接打印map, 会调用map接口引用 的HashMap对象的toString()方法
        //Map集合中键值对存储顺序与添加顺序可能不一样
        System.out.println(map);
        //{lisi=90, chenqi=50, zhangsan=80, wangwu=80}

        ///////注意: Map集合中键不允许重复, 在put添加键值对时, 如果键已存在,会使用 新的value值替换map集合中key键原来 的value值,并返回旧的value值
        Integer old = map.put("lisi", 100);
        System.out.println(map);          //{lisi=100, chenqi=50, zhangsan=80, wangwu=80}
        System.out.println(old);          //90
        //在put添加键值对时,如果键不存在,即是第一次向map集合中添加, put方法返回null
        old = map.put("zhaoliu", 30);
        System.out.println(old);          //null
        System.out.println(map);          //{lisi=100, chenqi=50, zhaoliu=30, zhangsan=80, wangwu=80}

        //3) 调用 get(key) 返回map集合中 key 键的value值
        System.out.println(map.get("lisi"));      //100,  返回map集合中lisi同学的成绩
        System.out.println(map.get("feifei"));    //null, 键不存在get方法返回null
        map.put(null, null);     //注意: HashMap集合的键值是可以为null的, 没有意义
        System.out.println(map);      //{null=null, lisi=100, chenqi=50, zhaoliu=30, zhangsan=80, wangwu=80}

        //4) 调用containsKey(k)判断map的键是否包含k
        System.out.println(map.containsKey("zhaoliu"));    //true, 表示map的第一列的学生成绩中存在zhaoliu同学
        System.out.println(map.containsKey("zhaoxiaoliu"));    //false

        //5) containsValue( v ) 判断map的值是否包含v
        System.out.println(map.containsValue(100));      //true, 表示map的第二列存在成绩为100分的同学
        System.out.println(map.containsValue(55));         //false

        //6) 调用keySet()方法返回所有键的集合
        Set<String> keySet = map.keySet();
        System.out.println(keySet);   //[null, lisi, chenqi, zhaoliu, zhangsan, wangwu], 返回第一列所有同学的姓名

        //7) 调用values()返回所有 值的集合
        Collection<Integer> values = map.values();
        System.out.println(values);   //[null, 100, 50, 30, 80, 80] 返回了第二列所有同学的成绩

        //8) 调用entrySet()返回所有键值对的集合, 一个Entry就是一个键值对, 该方法返回值是一个Set集合, Set集合存储的是Entry,Entry的数据类型是: Map.Entry<String, Integer>.   Entry是Map接口的一个内部接口. 将来遇到 类名1.类名2 形式时, 说明类名2是类名1的内部类
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);
        //[null=null, lisi=100, chenqi=50, zhaoliu=30, zhangsan=80, wangwu=80]

        System.out.println("================================================");
        //9) 调用remove( key )删除map集合中key键对应的键值对
        map.remove(null);       //从map集合中删除第一列姓名为null的键值对
        System.out.println(map);
        System.out.println(map.remove("gf"));
        System.out.println(map);
        //{lisi=100, chenqi=50, zhaoliu=30, zhangsan=80, wangwu=80}

        System.out.println("10================================================================");
        //10) 调用replace( k , v) 把map集合中k键的值替换为v.   在put(k,v)添加键值对时,当k键已存在就是替换功能. replace(k,v)替换的前提是k键已存在
        System.out.println(map.replace("lisi2", 99));
        System.out.println(map);
        //{lisi=99, chenqi=50, zhaoliu=30, zhangsan=80, wangwu=80}
        map.replace("feifei", 20);      //map集合中不存在feifei键, 替换失败
        System.out.println(map);
        //{lisi=99, chenqi=50, zhaoliu=30, zhangsan=80, wangwu=80}
    }
}