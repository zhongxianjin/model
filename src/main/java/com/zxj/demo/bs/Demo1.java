package com.zxj.demo.bs;

/**
 * Created by upczh on 2019/9/4.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Demo1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int mid = sum / m;
        int k = 0;
        int[] time=new int[m];
        int count=0;
        for (int j = 1; j <= m; j++) {
            for (; k < array.length; k++) {
                count+=array[k];
                if(count>=j*mid){
                    time[j-1]=count-(j-1)*mid;
                    break;
                }
            }
        }
        Arrays.sort(time);
        return time[m-1];
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}
