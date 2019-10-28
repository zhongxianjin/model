package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by upc on 2019/9/18.
 */
public class IQIYI {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[] A=new int[(int)Math.pow(2,n)];
        for(int i=0;i<A.length;i++){
            A[i]=scan.nextInt();
        }
        for(int i=0;i<m;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            System.out.println(cal(A,a,b));
        }
    }
    public static int cal(int[] A,int a, int b){
        A[a-1]=b;
        ArrayList<Integer> array=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            array.add(A[i]);
        }
        int i=0,len=A.length;
        boolean flag=true;
        while(array.size()>1){
            if(flag){
                array.set(i,array.get(i)|array.get(i+1));
                array.remove(i+1);
                i++;
                if(i==len/2){
                    flag=false;
                    i=0;
                    len/=2;
                }
            }else {
                array.set(i,array.get(i)^array.get(i+1));
                array.remove(i+1);
                i++;
                if(i==len/2){
                    flag=true;
                    i=0;
                    len/=2;
                }
            }
        }
        return array.get(0);
    }
}
