package com.powernode.collection.set;

import java.util.TreeSet;

public class Test06TreeSet {
    public static void main(String[] args) {
        //定义TreeSet集合存储Student对象，调用TreeSet(Comparator)构造方法，通过Comparator指定根据成绩降序排序
        TreeSet<Student> treeSet1 = new TreeSet<>((o1, o2) -> {
            //o1的成绩大返回负数，成绩相等返回0，o1成绩小返回正数，对应成绩降序
            return Integer.compare(o2.score, o1.score);
        });
        treeSet1.add(new Student("zhangsan", 80));
        treeSet1.add(new Student("lisi", 40));
        treeSet1.add(new Student("wangwu", 50));
        treeSet1.add(new Student("zhaoliu", 70));
        treeSet1.add(new Student("chenqi", 60));
        treeSet1.add(new Student("zhuba", 90));
        /*
         * 当前treeSet1集合只判断学生的成绩，如果两个学生成绩相等，则compare方法返回0。
         * 当compare返回0时，treeSet1集合就认为这两个元素重复，因此添加失败，下面的语句输出false
         */
        System.out.println(treeSet1.add(new Student("feifei", 90)));

        for (Student student : treeSet1) {
            System.out.println(student);
        }

        //如果调用TreeSet<>()无参构造方法创建TreeSet对象，要求集合中存储元素本身具有比较大小的能力，即元素的类要实现Comparable接口
        TreeSet<Student> treeSet2 = new TreeSet<>();
        treeSet2.addAll(treeSet1);  //把treeSet1集合中的元素都添加到treeSet2集合中
        System.out.println("---------------------");
        for (Student student : treeSet2) {
            System.out.println(student);
        }

    }

    //以静态内部类的形式定义Student类, 实现Comparable接口
    static class Student implements Comparable<Student> {
        String name;
        int score;

        //重写Comparable接口抽象方法,定义一个比较规则 ,比较两个学生对象的姓名
        @Override
        public int compareTo(Student o) {
            return this.name.compareTo(o.name);     //第一个对象的姓名大返回正数,对应升序
        }

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
    }
}