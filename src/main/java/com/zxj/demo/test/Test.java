package com.zxj.demo.test;

import java.util.Scanner;

/**
 * Created by upczh on 2019/8/11.
 */
public class Test {
    static int count = 0;
    static int M = 0;
    static int Sn=0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int S = scan.nextInt();
        Sn=S;
        if (N < 1 || N > S) {
            System.out.println(0);
        } else {
            int[] arr = new int[S];
            for (int i = 0; i < S; i++) {
                arr[i] = i + 1;
            }
            M=N;
            int[] b = new int[N];
//            System.out.println(S);
            C(S, N, arr, b);
//            C1(S, N, arr, b);

            System.out.println(count);
        }
    }

    static void C(int S, int n, int[] arr, int[] b) {

        for (int i = n; i <= S; i++) {
            b[n - 1] = i - 1;
            for(int k=0;k<b.length;k++)
                System.out.print(" b:"+b[k]);
            System.out.println();
            if (n > 1)
                C(i - 1,n - 1,  arr, b);
            else {
                int value = 0;
                for (int j = 0; j < M; j++)
                    value += arr[b[j]];
//                System.out.println("value:"+value);
                if (value == Sn) {
//                    for(int j=0;j<M;j++)
//                        System.out.print(arr[b[j]] + " ");
//                    System.out.println();
                    count++;
                }

            }
        }
    }
    static void C1(int n,int m,int[] a,int[] b){
        int i,j;
        for(i=m;i<=n;i++) {
            b[m-1] = i-1;
            if(m>1)
                C1(i-1,m-1,a,b);
            else {
                for(j=0;j<=M-1;j++)
                    System.out.print(a[b[j]] + "  ");
                System.out.println();
            }
        }
    }
//    static void C(int n1,int m1){
//        int i,j;
//        for(i=m1;i<=n1;i++) {
//            b[m1-1] = i-1;
//            if(m1>1)
//                C(i-1,m1-1);
//            else {
//                for(j=0;j<=n1-1;j++)
//                    System.out.print(a[b[j]] + "  ");
//                System.out.println();
//            }
//        }
//    }
}
