package com.powernode.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test02Collection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();   //从JDK7开始,只需要在前面定义集合时通过泛型指定元素类型即可,在后面new集合对象时, 不需要再显示指定元素类型了, 这称为钻石表达式

        //向集合中添加数据时, 只有添加泛型指定的STring字符串
        collection.add("hello");
        collection.add("girl");
        collection.add("good");
        collection.add("nice");
        collection.add("world");
        //collection.add(456);    //添加数据不是泛型指定的类型则语法错误,这就是泛型的好处,可以在编译阶段进行数据类型检查
        System.out.println(collection);   //[hello, girl, good, nice, world]

        //调用Collection集合的 iterator()方法返回 Iterator 迭代器, 迭代器是用于访问集合的每个元素的
        Iterator<String> iterator = collection.iterator();  //迭代器的泛型与集合的泛型是一致的
        //刚刚调用iterator()方法返回一个新迭代器时, 迭代器有一个游标,指向第一个元素的最前面
        //Iterator迭代器有 hasNext()方法判断游标后面是否还有元素
        //next()返回游标后面的元素, 同时把游标下移
        //当 hasNext() 返回true, 表示游标后面还有元素时, 可以next()返回游标后面的元素了
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next + "    ");
        }
        System.out.println();

        //经过上面的循环后, iterator迭代器的游标就指向最后一个元素的后面了, 这个迭代器就失效了, Iterator迭代器是一次性的
        //如果还想迭代, 重新调用 iterator() 方法返回一个新的迭代器. 在实际开发中, 在IDEA环境里,可以直接输入itco会生成迭代代码块
        for (Iterator<String> it = collection.iterator(); it.hasNext(); ) {
            //for循环初始化表达式,调用collection.iterator()方法返回一个新的迭代器it
            //for循环条件是it.hasNext()返回true表示游标后面还有元素
            //for循环体中调用 it.next()方法返回游标后面的元素后, 游标下移
            String next = it.next();
            System.out.print(next + "   ");
        }
        System.out.println();

        //需求: 删除集合中以 "g" 开始的字符串
        //遍历集合中的元素,如果这个元素以g开头就删除
        /*for (String s : collection) {
            if ( s.startsWith("g") ){
                collection.remove(s);
            }
        }
            foreach循环仅用于遍历访问, 在foreach循环期间, 调用collection集合的add()添加数据, 或者调用collection集合的remove()删除元素时, 都有可能产生ConcurrentModificationException并发操作异常
        */
        //从Collection集合中删除多个符合条件的数据时, 可以通过迭代器遍历 , 迭代器删除
        for (Iterator<String> it = collection.iterator(); it.hasNext(); ) {
            String next = it.next();
            if (next.startsWith("g")) {
                it.remove();        //调用迭代器的remove()删除刚刚 next() 返回的元素
                // collection.remove(next);    //ConcurrentModificationException. 注意,在迭代过程中,调用collection集合的add()添加数据, 或者调用collection集合的remove()删除元素时, 都有可能产生ConcurrentModificationException并发操作异常
            }
        }
        System.out.println(collection);    //[hello, nice, world]
    }
}