package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer7 {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        return Calculation(n);
    }

    public int Calculation(int n) {
        if (n > 2)
            return Calculation(n - 1) + Calculation(n - 2);
        else {
            return 1;
        }
    }
}
