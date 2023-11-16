package com.powernode.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        //1 创建Stream流
        //1.1 可以根据数组创建Stream流
        String[] namesArr = {"zhangsan", "lisi", "wangwu", "chenqi", "handily", "zhaoliu"};
        //调用Arrays.stream(数组名)生成Stream流
        Stream<String> nameStream = Arrays.stream(namesArr);
        //1.2 根据Collection集合生成Stream流
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 80));
        list.add(new Student("lisi", 90));
        list.add(new Student("wangwu", 40));
        list.add(new Student("zhaoliu", 50));
        list.add(new Student("chenqi", 70));
        list.add(new Student("zhuba", 30));
        //调用Collection集合的stream()方法生成Stream流
        Stream<Student> studentStream = list.stream();
        //1.3 调用Stream.of()方法在若干数据上生成Stream流
        Stream<Integer> integerStream = Stream.of(67, 43, 87, 32, 90, 32, 546, 43, 32);

        //2 终端操作
        //2.1 forEach(Consumer<? super T> action) 遍历流中的每个元素
        nameStream.forEach(System.out::println);
        studentStream.forEach(System.out::println);
        //2.2 collect(Collector<? super T,A,R> collector) 归约
        List<Integer> integerList = integerStream.collect(Collectors.toList());     //把流中的元素转换List集合
        //Stream流是一次性的
        //Set<Integer> set = integerStream.collect(Collectors.toSet());   //把流中的元素保存到Set集合中
        String str = Arrays.stream(namesArr)        //重新生成一个新的Stream流
                .collect(Collectors.joining("-"));  //把流中的元素使用-连接为一个字符串
        System.out.println(str);

        //2.3 toArray() 把流中的元素转换为数组
        Object[] array = list.stream()       //根据list集合生成Stream流
                .toArray();     //把流中的元素保存到数组中
        for (Object o : array) {
            System.out.println(o);
        }
        //2.4allMatch(Predicate<? super T> predicate)   判断流中的元素是否都匹配predicate条件
        boolean allMatch = list.stream()
                .allMatch(s -> s.score > 60);  //流中所有同学的成绩都大于60分
        System.out.println(allMatch);
        //2.5anyMatch(Predicate<? super T> predicate)   判断流中是否存在某一个元素匹配predicate条件
        boolean result = list.stream()
                .anyMatch(s -> s.score > 60);      //流中有某个元素的成绩大于60分
        System.out.println(result);
        //2.6 count()统计流中元素的数量
        long count = list.stream().count();
        System.out.println(count);

        //3 中间操作
        //3.1 filter(Predicate<? super T> predicate)    筛选符合predicate条件的元素
        Arrays.stream(namesArr)        //根据数组生成Stream流
                .filter(s -> s.length() > 5)       //筛选长度大于5的字符串
                .forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();
        list.stream()
                .filter(student -> student.score > 60)        //筛选大于60分的同学
                .forEach(System.out::println);

        //3.2 map(Function<? super T,? extends R> mapper) 映射, 对流中的每个 元素进行mapper操作
        Arrays.stream(namesArr)
                .map(s -> s.concat("nice"))        //对流中的每个元素连接nice
                .forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();
        list.stream()
                .filter(s -> s.score > 60)     //筛选大于60分的同学
                .map(s -> s.getName())         //对流中的每个 元素调用getName()方法,现在流中的元素变 为String字符串
                .forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();

        //3.3 sorted(Comparator<? super T> comparator) 对流中的元素进行排序
        list.stream()
                .sorted((s1, s2) -> s1.score - s2.score)
                //.sorted( Comparator.comparingInt(s2 -> s2.score))
                .forEach(s -> System.out.println(s));  //遍历打印
        System.out.println();
        //3.4 distinct() 去掉流中重复的元素
        Stream.of(67, 43, 87, 67, 43, 67)
                .distinct()
                .forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();
        //3.5 limit(long maxSize) 截取前maxSize个元素
        Arrays.stream(namesArr)
                .sorted()    //默认字符串升序
                .limit(3)   //取前3个
                .forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();

        System.out.println("================================");
        //3.6 flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
        String[] arr2 = {"good", "nice", "hello", "world"};
        //根据 nameArr, arr2 这两个数组生成Stream流
        Stream<String[]> arrayStream = Stream.of(namesArr, arr2);
        Stream<String[]> arrayStream1 = Stream.of(namesArr, arr2);
        System.out.println("arrayStream1中的元素遍历：");
        arrayStream1.forEach(s -> System.out.print(Arrays.toString(s) + "  "));
        System.out.println();
        //现在arrayStream流中的元素是String[]数组,这些数组中还存储一些字符串
        //需求: 把arrayStream流中数组的字符串取出来生成一个新的Stream流,调用flatMap
        Stream<String> stringStream = arrayStream.flatMap(arr -> Arrays.stream(arr));
        System.out.println("stringStream中的元素遍历：");
        stringStream.forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();
        System.out.println("================================================");
/*        String[] split = "zhangsan".split("");
        for (String s : split) {
            System.out.print(s + "  ");
        }
        System.out.println();*/
        Arrays.stream(namesArr)     //流中元素是String字符串 "zhangsan", "lisi", "wangwu"
                .map(s -> s.split(""))   //对流中的每个 字符串进行拆分[z,h,a,n,g,s,a,n]  [l,i,s,i] [w,a,n,g,w,u]. 现在流中的元素是 String[]数组
                .flatMap(split -> Arrays.stream(split))   //对流中的每个数组调用Arrays类的stream()把数组中的元素取出来组成一个新的流
                .distinct()     //去重
                .forEach(s -> System.out.print(s + "  "));  //遍历打印
        System.out.println();


    }

    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }

        public String getName() {
            return name;
        }
    }
}