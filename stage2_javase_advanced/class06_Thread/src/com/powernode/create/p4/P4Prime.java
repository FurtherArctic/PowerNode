package com.powernode.create.p4;

import java.util.Random;
import java.util.concurrent.Callable;

public class P4Prime implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("call方法就是子线程要执行的代码");
        Random random = new Random();
        int num = random.nextInt(100);
        System.out.println("线程执行结果为:" + num);
        //返回线程的结果
        return num;
    }
}