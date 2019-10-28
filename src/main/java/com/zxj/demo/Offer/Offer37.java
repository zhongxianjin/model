package com.zxj.demo.Offer;

import java.util.HashMap;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer37 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */
    Offer37() {
        GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3);
    }

    public int GetNumberOfK(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.replace(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        if (map.containsKey(k))
            return map.get(k);
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        new Offer37();
    }
}
