package com.zxj.demo.Offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer63 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */
    public PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    public PriorityQueue<Integer> max = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer e1, Integer e2) {
            return e2 - e1;
        }
    });
    int count = 0;

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) {
            if (!max.isEmpty() && num < max.peek()) {
                max.offer(num);
                num = max.poll();
            }
            min.offer(num);
        } else {
            if (!min.isEmpty() && num > min.peek()) {
                min.offer(num);
                num = min.poll();
            }
            max.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0)
            throw new RuntimeException("no available number!");
        double result;
        if ((count & 1) == 0) {
            result = (max.peek() + min.peek()) / 2.0;
        } else {
            result = max.peek();
        }
        return result;
    }

}
