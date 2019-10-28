package com.zxj.demo.bs;

import java.util.Scanner;

/**
 * Created by upczh on 2019/8/11.
 */
public class Pdd {
    //    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int N = scan.nextInt();
//        int M = scan.nextInt();
//        int[] x = new int[M];
//        int[] y = new int[M];
//        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//        for (int i = 0; i < M; i++) {
//            x[i] = scan.nextInt();
//            y[i] = scan.nextInt();
//            map.put(x[i],y[i]);
//        }
//        if(N<=3||N>=200||M>=N*N){
//            System.out.print(0);
//        }else{
//            if(M==0){
//                System.out.println(N);
//            }else {
//                for(int i=0;i<N;i++){
//
//                }
//            }
//        }
//    }
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int N=scan.nextInt();
//        int S=scan.nextInt();
//        int count=0;
//        if(N<1||N>S){
//            System.out.println(0);
//        }else {
//
//            for(int i=1;i<S-i;i++){
//                for(int j=i+1;j<S-(i+j);j++){
//                    for(int k=j+1;k<S-(i+j+k);k++){
//                        if((i+j+k)==S){
//                            count++;
//                        }
//                    }
//                }
//            }
//            System.out.print(count);
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int L = scan.nextInt();
//        int N = scan.nextInt();
//        int[] number = new int[N];
//        for (int i = 0; i < N; i++) {
//            number[i] = scan.nextInt();
//        }
//        Arrays.sort(number);
//        if (N > L) {
//            System.out.println(0);
//        } else {
//            int midCount = 0;
//            for (int i = 0; i < N; i++) {
//                midCount += Math.abs(number[i] - number[N / 2]) - 1;
//            }
//            int lefCount = 0;
//            for (int i = 0; i < N; i++) {
//                if (number[i] < L / 2) {
//                    lefCount += number[i] - i;
//                } else {
//                    lefCount += L - number[i] + i - N;
//                }
//            }
//            int MidC = 0;
//            for (int i = 0; i < N; i++) {
//                if (number[i] < (number[N - 1] - number[0]) / 2) {
//                    MidC += (number[N - 1] - number[0]) / 2 - number[i] - 1 - i;
//                } else {
//                    MidC += number[i] - (number[N - 1] - number[0]) / 2 - N + i;
//                }
//            }
//
//            System.out.println(Math.min(Math.min(midCount, lefCount), MidC));
//        }
//    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N=scan.nextInt();
        int[] arr= new int[N];
        int count=0;
        if(N<3){
            System.out.println(0.00);
        }else {
            for(int i=0;i<N;i++){
                arr[i]=scan.nextInt();
            }
            double valueNumber=value(arr[0],arr[1],arr[2]);
            for(int i=1;i<N;i++){
                for(int j=i+1;j<N;j++){
                    for(int k=j+1;k<N;k++){
                        count++;
                        valueNumber=Math.min(valueNumber,value(arr[i],arr[j],arr[k]));
                    }
                }
            }
            System.out.println(String.format("%.2f", valueNumber));
        }
        System.out.println(count);

    }
    public static double value(int x1,int x2, int x3){
        double avg=(x1+x2+x3)/3.0;
        double number=Math.pow(avg-x1,2)+Math.pow(avg-x2,2)+Math.pow(avg-x3,2);
        return number/3.0;
    }
}
