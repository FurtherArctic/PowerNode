package com.powernode.homework;

import java.util.Arrays;

public class Test01Stack {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println(stack.push("stack1"));
        System.out.println(stack.push("stack2"));
        System.out.println(stack.push("stack3"));
        System.out.println(stack.push("stack4"));
        System.out.println(stack.push("stack5"));
        System.out.println(stack.push("stack6"));
        System.out.println(stack.push("stack7"));
        System.out.println(stack.push("stack8"));
        System.out.println(stack.push("stack9"));
        System.out.println(stack.push("stack0"));
        System.out.println(stack.push("stack10"));
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

    }

}

class Stack {
    private Object[] elements;
    private int top;

    /**
     * 一般情况下会在无参构造方法中对数组默认初始化,初始化容量需要估算
     */
    public Stack() {
        elements = new Object[10];
    }

    /**
     * 有时,会通过构造方法指定数组初始化大小,为了避免频繁扩容
     *
     * @param capacity 初始长度
     */
    public Stack(int capacity) {
        capacity = Math.max(capacity, 0);
        elements = new Object[capacity];
    }

    /**
     * 入栈操作
     *
     * @param data 数据
     * @return 入栈是否成功
     */
    public boolean push(Object data) {
        if (top == elements.length) {
            return false;
        }
        elements[top++] = data;
        return true;
    }

    /**
     * 出栈操作，将栈顶元素弹出，重新填充为null，top指针下移
     *
     * @return
     */

    public Object pop() {
        if (top == 0) {
            return null;
        }
        top--;
        Object data = elements[top];
        elements[top] = null;
        return data;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", top=" + top +
                '}';
    }
}