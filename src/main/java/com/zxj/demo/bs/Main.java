package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by upczh on 2019/8/17.
 */
public class Main {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] v=new int[n];
        for(int i=0;i<n;i++){
            v[i]=scan.nextInt();
        }
        int[] result=new int[n];
        Arrays.fill(result,1);
        for(int i=0;i<n;i++){
            int leftMax=0,rightMax=0,leftIndex=0,rightIndex=0;
            for(int j=i-1;j>=0;j--){
                if(leftMax>=v[i]){
                    leftIndex=j;
                    break;
                }
                if(leftMax<v[j]){
                    leftMax=v[j];
                }
            }
            for(int k=i+1;k<n;k++){

            }
            if(i>0)leftMax=v[i-1];
            if(i<n-1)rightMax=v[i+1];
            for(int j=i-1;j>0;j--){//left
                if(leftMax<v[j-1]) {
                    leftMax = v[j];
                }else if(leftMax>=v[j]&&leftMax<v[i]){
                    result[i]--;
                }
                if(v[j]>=v[j-1]){
                    if(v[i]<=v[j]&&j!=i)
                        break;
                    else if(j!=i) {
                        result[i]--;
                    }
                }
                result[i]++;
            }
            for(int k=i;k<n-1;k++){//right
                if(v[k]>=v[k+1]){
                    if(v[i]<=v[k]&&k!=i)
                        break;
                    else if(v[i]>v[k]&&k!=i) {
//                        result[i]--;
                    }else if(k==i){

                    }
                    if(v[k]>=v[k+1]&&v[i]>=v[k]&&k!=i){
                        result[i]--;
                    }
                }
                result[i]++;
            }
        }
        for(int i=0;i<n;i++)
            System.out.print(result[i]+" ");
    }

}
