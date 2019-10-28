package com.zxj.demo.bs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by upc on 2019/9/16.
 */
public class LC {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int[] array=new int[N];
        if(N<=0)System.out.print(1+" "+50);
        else{
            for(int i=0;i<N;i++){
                array[i]=scan.nextInt();
            }
            Arrays.sort(array);
            int index=1,max=0,first=0,second=0;
            if(array[0]%2!=0){
                max=(array[0]+1)/2-1;
                index=1;
                first=array[0];
            }else{
                max=array[0]/2-1;
                index=2;
                second=array[0];
            }
            for(int i=1;i<array.length;i++){
                if(array[i]%2==0){
                    if((array[i]-second)/2>max){
                        index=second+2;
                        max=(array[i]-second)/2;
                        second=array[i];
                    }
                }else{
                    if((array[i]-first)/2>max){
                        index=first+2;
                        max=(array[i]-first)/2;
                        first=array[i];
                    }
                }
            }
            if((100-second)/2>max){
                index=second+2;
                max=(100-second)/2;
            }

            if((99-first)/2>max){
                index=first+2;
                max=(99-first)/2;
            }
            System.out.print(index+" "+max);
        }

    }
}
