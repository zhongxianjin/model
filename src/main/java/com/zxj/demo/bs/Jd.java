package com.zxj.demo.bs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by upczh on 2019/8/23.
 */
public class Jd {
//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        while(scan.hasNextInt())
//        {
//            int n=scan.nextInt();
//            int m=scan.nextInt();
//            Sum(n,m);
//        }

    //    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] H = new int[N];
        HashMap<Integer, Integer> map = new HashMap();
        int[][] c = new int[N][2];
        for (int i = 0; i < N; i++) {
            H[i] = scan.nextInt();
            c[i][0] = H[i];
            c[i][1] = i;
        }
        int count = 0;
        Arrays.sort(H);
        Arrays.sort(c, (e1, e2) -> {
            return (int) (e1[0] - e2[0]);
        });
        for (int i = 0; i < N; i++) {
            System.out.println(c[i][0]+":"+c[i][1]);
        }
        int flag=0;
        for (int i = 0; i < N - 1; i++) {
            if (c[i][1] == c[i + 1][1]+1) {
                if(flag==0)
                count++;
                flag++;
                System.out.println(c[i][1]+":"+c[i+1][1]);
                continue;
            }
            System.out.println(c[i][1]);
            if(flag>0){
                flag=0;
            }else {
                count++;
            }

            System.out.println("count:"+count);
        }
        System.out.print(count);
    }


    public static void Sum(int n, int m) {
        double sum = 0;
        double n1 = n;
        for (int i = 0; i < m; i++) {
            sum += Math.sqrt(n1);
            n1 = Math.sqrt(n1);
        }
        System.out.println(String.format("%.2f", sum));
    }
}
