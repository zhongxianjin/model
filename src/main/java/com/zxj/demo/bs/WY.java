package com.zxj.demo.bs;

import java.util.Scanner;

/**
 * Created by upc on 2019/9/21.
 */
public class WY {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        int x[]=new int[T];
        for(int i=0;i<T;i++){
            x[i]=scan.nextInt();
        }
        System.out.println(minSum(x));
    }
    public static int minSum(int[] x){
        int sum=0,max=0;
        for(int i=0;i<x.length;i++){
            if(max<=x[i]){
                max=x[i];
            }else{
                for(int j=i-1;j>=0;j--){
                    if(x[j]>x[i]){
                        sum+=(i-j);
                    }
                }
            }
        }
        return sum;
    }

//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        int T=scan.nextInt();
//        for(int i=0;i<T;i++){
//            int A=scan.nextInt();
//            int B=scan.nextInt();
//            int p=scan.nextInt();
//            int q=scan.nextInt();
//            System.out.println(minSum(A,B,p,q));
//        }
//    }
//    public static int minSum(int A,int B,int p,int q){
//        int i=0;
//        while(A<B){
//            if(B-A>2*p){
//                A+=p*q;
//                i+=2;
//            }else{
//                A+=p;
//                i++;
//            }
//        }
//        return i;
//    }

//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        int T=scan.nextInt();
//        for(int i=0;i<T;i++){
//            int x=scan.nextInt();
//            System.out.println(minSum(x));
//        }
//    }
//    public static long minSum(int x){
//        if(x/10==0){
//            return x;
//        }
//        int sum=0,count=0;
//        while(x/10!=0){
//            sum=sum+9*(int)Math.pow(10,count);
//            count++;
//            x-=9;
//        }
//        sum=sum+x*(int)Math.pow(10,count);
//        return sum;
//    }
}
