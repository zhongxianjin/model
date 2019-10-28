package com.zxj.demo.test;

import java.util.Stack;

/**
 * Created by upc on 2019/7/21.
 */
public class StackTest {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>(); //辅助栈：栈顶永远保存stack中当前的最小的元素


    public void push(int data) {
        stack.push(data);  //直接往栈中添加数据

        //在辅助栈中需要做判断
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());   //【核心代码】peek方法返回的是栈顶的元素
        }
        System.out.println(minStack.peek());
    }

    public int pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("栈中为空");
        }

        int data = stack.pop();
        minStack.pop();  //核心代码
        return data;
    }

    public int min() throws Exception {
        if (minStack.size() == 0) {
            throw new Exception("栈中空了");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        int i=5;
        System.out.println((i++));
        System.out.println(i);
        System.out.println((++i));
        System.out.println(i);
        i=1;
        int s=(i++)+(++i)+(i--)+(--i);
        System.out.println(s);
        i=1;
        s=(i++)+(++i);
        System.out.println(s);
        s=(i--)+(--i);
        System.out.println(s);
        StackTest stack = new StackTest();
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(7);

        System.out.println(stack.min());
    }
}
