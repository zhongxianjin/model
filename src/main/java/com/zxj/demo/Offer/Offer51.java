package com.zxj.demo.Offer;

import java.util.Arrays;

/**
 * Created by upc on 2019/9/13.
 */
public class Offer51 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     *
     * @param A
     * @return
     */
//    public int[] multiply(int[] A) {
//        int[] B = new int[A.length];
//        if (A == null || A.length <= 0) return B;
//        Arrays.fill(B, 1);
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                B[i] *= A[j];
//            }
//        }
//        return B;
//    }
    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        if(A==null||A.length<=0)return B;
        Arrays.fill(B,1);

        for(int i=1;i<A.length;i++){
            B[i]=B[i-1]*A[i-1];
        }
        long temp=1;
        for(int j=A.length-2;j>=0;j--){
            temp*=A[j+1];
            B[j]*=temp;
        }
        return B;
    }
}
