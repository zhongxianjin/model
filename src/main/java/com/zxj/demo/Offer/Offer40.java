package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer40 {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */
    Offer40() {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, num1, num2);
        System.out.println(num1[0] + ":" + num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 4) return;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.replace(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int flag = 1;
        while (iterator.hasNext()) {

            int key = iterator.next().getKey();
            int value = map.get(key);
            if (value == 1 && flag == 1) {
                num1[0] = key;
                flag++;
                continue;
            }
            if (value == 1 && flag == 2) {
                num2[0] = key;
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Offer40();
    }
}
