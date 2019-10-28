package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer8 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        int sum = 0, target1 = 2, target2 = 1;
        for (int i = 3; i <= target; i++) {
            sum = target1 + target2;
            target2 = target1;
            target1 = sum;
        }
        return sum;
    }
}
