package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer12 {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if(base==0&&exponent!=0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
        return Math.pow(base,exponent);
    }
}
