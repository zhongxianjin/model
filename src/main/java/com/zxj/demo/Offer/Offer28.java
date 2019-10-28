package com.zxj.demo.Offer;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by upc on 2019/9/11.
 */
public class Offer28 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    Offer28(){
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        TreeMap<Integer,Integer> treemap=new TreeMap<>();
        for(int i=0;i<array.length;i++){
            if(treemap.containsKey(array[i]))
                treemap.put(array[i],treemap.get(array[i])+1);
            else{
                treemap.put(array[i],1);
            }
        }
        int maxValue=treemap.get(array[0]),maxKey=array[0];
        Iterator<Integer> iterator=treemap.keySet().iterator();
        while(iterator.hasNext()){
            int key=iterator.next();
            int value=treemap.get(key);
            if(value>maxValue){
                maxValue=value;
                maxKey=key;
            }
        }
        if(maxValue>(array.length/2)){
            return maxKey;
        }else{
            return 0;
        }
    }
    public static void main(String[] args){
        new Offer28();
    }
}
