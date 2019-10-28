package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by upc on 2019/9/11.
 */
public class Offer32 {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            temp.add(numbers[i]);
        }
        Collections.sort(temp, new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                String str1 = e1 + "" + e2;
                String str2 = e2 + "" + e1;
                return str1.compareTo(str2);
            }
        });
        String result = "";
        for (int tempInteger : temp) {
            result += tempInteger;
        }
        return result;
    }
}
