package com.bjpowernode.exceptions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author wangjunchen
 * 方法覆盖的规则
 * 1) 方法签名必须相同, 方法名与参数列表
 * 2) 返回值类型可以相同 , 也可以是子类型
 * 3) 访问权限可以相同, 也可以更大
 * 4) 抛出的异常可以相同,也可以更小
 */
public class Test07Override {
    class Father {
        protected Number m1(int x) {
            return Integer.valueOf(x);
            //方法返回值类型是Number父类, 在方法体中可以return子类对象
        }

        public void m2() throws IOException {
            //在方法体中有 UnsupportedEncodingException子异常需要预处理, 可以throws抛出 IOException 父异常
            byte[] gbks = "Hello".getBytes("GBK");
        }
    }

    class Son extends Father {
        @Override
//    protected Number m1(int x) {
//    protected Integer m1(int x) {       //返回值类型也可以是子类型
        public Integer m1(int x) {       //访问权限可以提升为public
            return Integer.valueOf(x);
            /*
             *  1) 方法签名必须相同, 方法名与参数列表, m1(int)
             *  2) 返回值类型可以相同 , 也可以是子类型
             *  3) 访问权限可以相同, 也可以更大
             *  4) 父类方法没有声明抛出异常, 重写后也不能声明抛出异常
             */
        }

        @Override
//    public void m2() throws IOException {
//    public void m2() throws UnsupportedEncodingException {  //声明抛出子异常
        public void m2() {     //不抛出异常
            try {
                byte[] gbks = "Hello".getBytes("GBK");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            /*
             *  1) 方法签名必须相同, 方法名与参数列表, m2()
             *  2) 返回值类型void,只能相同
             *  3) 访问权限public, 只能相同
             *  4) 父类方法声明抛出了异常, 重写后可以声明抛出相同的异常, 也可以声明抛出子异常, 或者不抛出异常
             */
        }
    }
}