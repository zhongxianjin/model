package com.zxj.demo.test;

import java.util.Arrays;

/**
 * Created by upc on 2019/8/17.
 */
public class ArrayTest {
    public static void main(String[] args){
        int[][] arr={{1,2},{3,5},{2,4},{6,7},{5,3}} ;
        Arrays.sort(arr,(e1,e2)->{return (int)(e2[0]-e1[0]);});
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int[] array={3,1,5,4,3};
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
