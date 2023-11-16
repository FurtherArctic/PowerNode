package com.powernode.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class Test04Customization {
    public static void main(String[] args) {
        //定义Collection集合存储Student对象, 通过泛型指定存储元素的类型, Collection接口赋值实现类对象
        Collection<Student> collection = new ArrayList<>();

        //向集合中添加 10 个Student对象
        collection.add(new Student("zhangsan", 90));
        collection.add(new Student("lisi", 50));
        collection.add(new Student("wangwu", 70));
        collection.add(new Student("zhaoliu", 80));
        collection.add(new Student("chenqi", 20));
        collection.add(new Student("zhuba", 30));
        collection.add(new Student("sunjiu", 70));
        collection.add(new Student("feifei", 40));

        //判断集合中是否存在某个Student对象
        Student stu = new Student("zhaoliu", 80);
        System.out.println(collection.contains(stu));   //当前collection实际引用的是ArrayList对象,通过collection调用contains()方法时, 实际执行的是ArrayList集合的contains()方法. 在ArrayList集合的contains()方法中需要调用对的equals方法, 在Student类中如果没有重写equals/hashCode方法,则返回false;  在Student类中重写了equals/hashCode方法则返回true

        //判断集合中是否存在姓名为wangwu的Student对象
        System.out.println(collection.contains("wangwu"));    //collection.contains("wangwu")判断collection集合是否包含"wangwu"这个字符串, 当前collection存储的是Student对象,所以返回false
        //正确思路: 遍历集合中的每个Student对象,如果有某个对象的姓名与wangwu一样就说明存在, 所有同学的姓名都不匹配,说明不存在
        boolean exist = false;   //定义存在标志
        for (Student student : collection) {
            if ("wangwu".equals(student.name)) {
                exist = true;
                break;
            }
        }
        System.out.println(exist ? "存在wangwu" : "不存在wangwu");

        //删除所有 不及格的同学 , 删除多个符合条件元素时,使用迭代器删除
        for (Iterator<Student> iterator = collection.iterator(); iterator.hasNext(); ) {
            Student next = iterator.next();
            if (next.score < 60) {
                iterator.remove();
            }
        }

        //foreach遍历
        for (Student student : collection) {
            System.out.println(student);
        }

    }

    //以静态内部类的形式定义Student学生类
    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return score == student.score &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score);
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