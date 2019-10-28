package com.zxj.demo.Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer43 {
    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     *
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str, int n) {
        char[] array = str.toCharArray();
        if (array == null || array.length == 0) return "";
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        while (n > 0) {
            queue.offer(queue.poll());
            n--;
        }
        String result = "";
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }
}
