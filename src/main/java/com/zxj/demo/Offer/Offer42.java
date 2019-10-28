package com.zxj.demo.Offer;

import java.util.ArrayList;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer42 {
    Offer42(){
        FindNumbersWithSum(new int[]{1,2,4,7,11,15},15);
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<>();
        if(array==null||array.length<=1)return result;
        int first=0,second=1;
        while(first<second&&second<array.length){
            int count=array[first]+array[second];
            if(sum==count){
                result.add(array[first]);
                result.add(array[second]);
                break;
            }else if(sum>count){
                second++;
            }else{
                first++;
                second=first+1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        new Offer42();
    }
}
