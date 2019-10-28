package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by upc on 2019/9/11.
 */
public class Offer29 {
    Offer29(){
        GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
    }
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length < k) {
            return new ArrayList<Integer>();
        }
        Arrays.sort(input);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int j:result){
            System.out.println(j);
        }
        return result;

    }
    public static void main(String[] args){
        new Offer29();
    }
}
