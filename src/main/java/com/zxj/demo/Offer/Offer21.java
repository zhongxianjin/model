package com.zxj.demo.Offer;

import java.util.Stack;

/**
 * Created by upc on 2019/8/27.
 */
public class Offer21 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length < 1 || popA.length < 1) return false;
        if (pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int count = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[count]) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty();
    }
}
