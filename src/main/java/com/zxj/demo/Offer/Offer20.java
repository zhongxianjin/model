package com.zxj.demo.Offer;

import java.util.Stack;

/**
 * Created by upc on 2019/8/27.
 */
public class Offer20 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */
    Stack<Integer> temp = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (temp.isEmpty()) {
            temp.push(node);
        } else {
            if (temp.peek() > node)
                temp.add(node);
        }
    }

    public void pop() {
        if (stack.peek() == temp.peek())
            temp.pop();
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return temp.peek();
    }
}
