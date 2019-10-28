package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer64 {
    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
     * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     *
     * @param num
     * @param size
     * @return
     */

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length < 1 || size <= 0) return result;
        if (num.length < size) {
            return result;
        } else {
            for (int i = 0; i < num.length - size + 1; i++) {
                int[] temp = new int[size];
                temp = Arrays.copyOfRange(num, i, size + i);
                Arrays.sort(temp);
                result.add(temp[size - 1]);
            }
            return result;
        }
    }

    /**
     * 双端队列
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length < 1 || size <= 0) return result;
        LinkedList<Integer> indexDeque = new LinkedList<>();
        if (num.length < size) {
            return result;
        } else {
            for (int i = 0; i < size; i++) {
                while (indexDeque.size() > 0 && num[i] > num[indexDeque.getLast()])
                    indexDeque.removeLast();
                indexDeque.offerLast(i);
            }
            for (int i = size - 1; i < num.length; i++) {
                while (indexDeque.size() > 0 && num[i] > num[indexDeque.getLast()]) {
                    indexDeque.removeLast();
                }
                indexDeque.offerLast(i);
                if (i - size + 1 > indexDeque.getFirst()) {
                    indexDeque.removeFirst();
                }
                result.add(num[indexDeque.peekFirst()]);
            }
            return result;
        }
    }

}
