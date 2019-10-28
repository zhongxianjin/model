package com.zxj.demo.bs;

import java.util.Scanner;

/**
 * Created by upc on 2019/9/21.
 */
public class ST {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] m=new int[n];
        int[] copyM=new int[n];
        int min=200000,index=0;
        for(int i=0;i<n;i++){
            m[i]=scan.nextInt();
            if(m[i]<min){
                min=m[i];
                index=i;
            }
        }
        if(n<=1){
            System.out.print(m[0]);
            return;
        }
        if(n==2){
            if(min<0){
                System.out.print(m[0]>0?m[0]:m[1]);
                return;
            }else{
                System.out.print(m[0]+m[1]);
                return;
            }
        }
        for(int i=index;i<n;i++){
            copyM[i-index]=m[i];
        }
        for(int i=0;i<index;i++){
            copyM[i+n-index]=m[i];
        }
        m=null;
        if(min<0){
            int max=copyM[0],tempMax=copyM[0];
            for(int i=1;i<n;i++){
                tempMax=Math.max(copyM[i]+tempMax,copyM[i]);
                max=Math.max(tempMax,max);
            }
            System.out.print(max);
            return;
        }else{
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=copyM[i];
            }
            System.out.print(sum);
            return;
        }
    }

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n=scan.nextInt();
//        int x=scan.nextInt();
//        int count=0,tempX=x;
//        while(tempX!=0){
//            tempX/=10;
//            count++;
//        }
//        int i=10;
//        if(10>(n/x)){
//            i=10;
//        }else{
//            i=n/x;
//        }
//        for(;i<=n;i++){
//            long sum=0;
//            for(int j=0;j<count;j++){
//                sum+=((x/(int)Math.pow(10,j))%10)*(int)Math.pow(i,j);
//            }
//            if(sum>=x&&sum==n){
//                break;
//            }
//        }
//        System.out.print(i);
//    }
}
