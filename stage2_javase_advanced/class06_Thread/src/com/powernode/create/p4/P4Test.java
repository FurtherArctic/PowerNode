package com.powernode.create.p4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class P4Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3 创建线程对象,调用Thread(Runnable)构造方法, 借助FutureTask类, FutureTask类实现了RunnableFuture接口, 而RunnableFuture继承了Runnable接口, 即FutureTask类是Runnable接口的实现类
        //调用 FutureTask(Callable ) 构造方法先创建对象,
        FutureTask futureTask = new FutureTask(new P4Prime());
        Thread t = new Thread(futureTask);
        //4 开启线程
        t.start();

        System.out.println("main线程中开启了t线程, t线程最后执行call方法, call方法有返回结果, 可以通过Futuretask对象获得这个结果: " + futureTask.get());
    }
}