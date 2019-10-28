package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer10 {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
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
