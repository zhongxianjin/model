package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by upc on 2019/9/11.
 */
public class FR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        if (len <= 1) {
            System.out.print(0);
            return;
        }
        int number[] = new int[len];
        int count = 0, flag = -1, countPre = 0;
        ArrayList<Integer> fs=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            number[i] = in.nextInt();
            if (number[i] < 0) {
                fs.add(i);
            }
            if (number[i] == 0) {
                countPre = fs.size();
                flag = i;
            }
        }
        int sum = 1;
        if (flag == -1) {
            if (fs.size() % 2 == 0) {
                for (int i = 0; i < len; i++) {
                    sum *= number[i];
                }
                System.out.print(sum);
            } else {
                if(fs.size()<=1){
                    int sum1 = 1, sum2 = 1;
                    for (int i = 0; i < fs.get(0); i++) {
                        sum1 *= number[i];
                    }
                    for (int i = fs.get(0) + 1; i < len; i++) {
                        sum2 *= number[i];
                    }
                    System.out.print(Math.max(sum1, sum2));
                }else {
                    int sum1 = 1, sum2 = 1,max=0;
                    for (int i = 0; i < fs.get(0); i++) {
                        sum1 *= number[i];
                    }
                    for(int i=0;i<fs.size();i++){
                        if(i%2!=0){
                            int temp=1;
                            for (int j = 0; j < fs.get(i); j++) {
                                temp *= number[i];
                            }
                            max=Math.max(sum1,temp);
                        }else {

                        }
                    }

                    System.out.print(max);
                }
            }

        } else {
            if (countPre % 2 == 0) {
                int sum1 = 1, sum2 = 1;
                for (int i = 0; i < flag; i++) {
                    sum1 *= number[i];
                }
                for (int i = flag + 1; i < len; i++) {
                    sum2 *= number[i];
                }
                System.out.print(Math.max(sum1, sum2));
            } else {

            }
        }

    }
}
