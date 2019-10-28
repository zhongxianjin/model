package com.zxj.demo.Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer13 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public void reOrderArray(int [] array) {
        if(array==null||array.length<=1){
            return;
        }
        int[] newArray=new int[array.length];
        int j=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                newArray[j]=array[i];
                j++;
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                newArray[j]=array[i];
                j++;
            }
        }
        for(int i=0;i<array.length;i++){
            array[i]=newArray[i];
        }
    }
}
