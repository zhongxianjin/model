package com.zxj.demo.bs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by upczh on 2019/8/11.
 */
public class Main3 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
        int number=0;
        int[] array=new int[m];
        int[] array2=new int[m];
        int kNumber=0;
        int year=2019;
        for (int i=1;i<=m;i++){
            if(calculateYear(i)>=m){
                year=year+i-1;
                break;
            }
        }
        for (int i=0;i<m;i++){
            if(i==m-1){
                array2[i]=calculateNumber(i+1);
                number=array2[i];
                array[i]=reverse(array2[i]);
                break;
            }
            array2[i]=calculateNumber(i+1);
            array[i]=reverse(array2[i]);
        }
        Arrays.sort(array);
        for(int i=0;i<m;i++){
            if(reverse(array[m-k])==array2[i]){
                kNumber=i+1;
                break;
            }
        }

        return number+","+year+","+kNumber;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
    public static int calculateNumber(int m){
        if(m==1){
            return 2;
        }
        if(m==2){
            return 3;
        }
        if(m==3){
            return 4;
        }
        return calculateNumber(m-2)+calculateNumber(m-3);
    }
    public static int calculateYear(int m){
        if(m==1){
            return 2;
        }
        if(m==2){
            return 3;
        }
        return calculateYear(m-1)+calculateYear(m-2);
    }
    public static int reverse(int m){
        if(m<10){
            return m;
        }
        int n=0;
        while (m/10>0){
            n=m%10+n*10;
            m=m/10;
        }
        n=m%10+n*10;
        return n;
    }
}
