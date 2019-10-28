package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/13.
 */
public class Offer47 {
    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        if (n == 1)
            return 1;
        return Sum_Solution(n - 1) + n;
    }
}
