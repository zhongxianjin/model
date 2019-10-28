package com.zxj.demo.bs;

import java.util.Scanner;

/**
 * Created by upc on 2019/9/27.
 */
public class WYHY {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T=Integer.valueOf(scan.nextLine());

        for(int i=0;i<T;i++){
            String t=scan.nextLine();
            cacul(t);
        }
    }
    public static void cacul(String t){
        int sum=0,index=0;
        t=t.replaceAll("A","0");
        t=t.replaceAll("S","1");
        t=t.replaceAll("D","2");
        t=t.replaceAll("F","3");
        t=t.replaceAll("G","4");
        t=t.replaceAll("H","5");
        char[] array=t.toCharArray();
        if(array.length<=1){
            int temp1=array[0]-'0';
            System.out.println(Math.min(Math.abs(temp1),Math.abs(Math.abs(temp1-5))));
        }else{
            sum=Math.min(Math.abs((array[0]-'0')),Math.min(Math.abs((array[0]-'0')-index-5),Math.abs((array[0]-'0')-index+5)));
            index=array[0]-'0';
            for(int i=1;i<array.length;i++){
                int temp1=Math.abs((array[i]-'0')-index);
                int temp21=Math.abs((array[i]-'0')-index-6);
                int temp22=Math.abs((array[i]-'0')-index+5);
                int temp2=Math.min(temp21,temp22);
                sum=sum+Math.min(temp1,temp2);
                index=array[i]-'0';
            }
            System.out.println(sum);
        }

    }
}
