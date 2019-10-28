package com.zxj.demo.bs;

import org.apache.ibatis.jdbc.Null;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by upc on 2019/8/10.
 */
public class Main4 {
//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        int N=scan.nextInt();
//        int[] number=new int[N];
//        for(int i=0;i<N;i++){
//            number[i]=scan.nextInt();
//        }
//        int[] temp=new int[N];
//        for (int i=0;i<N;i++)temp[i]=number[i];
//        Arrays.sort(temp);
//        int index=0;
//        for(int i=0;i<N;i++){
//            if(temp[0]==number[i]){
//                index=i;
//                break;
//            }
//        }
//        for(int i=0;i<N;i++) System.out.print(" "+number[i]);
//        System.out.println("index="+index);
//        int count=0,min=temp[0];
//        int tp=100;
//        for(int i=index;i>0;i--){
//            if(number[i]==number[i-1]){
//                tp=tp;
//            }else if(number[i-1]>number[i]){
//                tp=tp+100;
//            }else if(number[i-1]<number[i]){
//                tp=100;
//            }
//            count=count+tp;
//            System.out.println("left:"+count);
//        }
//        tp=100;
//        for(int i=index;i<N-1;i++){
//            if(number[i]==number[i+1]){
//                tp=tp;
//            }else if(number[i+1]>number[i]){
//                tp=tp+100;
//            }else if(number[i+1]<number[i]){
//                tp=100;
//            }
//            count=count+tp;
//            System.out.println("right:"+count);
//        }
//        System.out.print(count+100);
//    }
//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        int N=scan.nextInt();
//        int K=scan.nextInt();
//        String str=scan.next();
//        char[] c=str.toCharArray();
//        int[] number=new int[N+K-1];
//        for(int i=0;i<N+K-1;i++)
//            number[i]=c[i]-'0';
//        int[] B=new int[N];
//        B[0]=number[N+K-2];
//        for(int i=1;i<N;i++){
//            int q=B[0];
//            if(i<=K-1){
//                for(int j=1;j<i;j++){
//                    q=q^B[j];
//                }
//            }else{
//                q=B[i-K+1];
//                for(int j=1;j<K-1;j++){
//                    q=q^B[i-K+1+j];
//                }
//            }
//            B[i]=number[N+K-2-i]^q;
//            System.out.println(i+":"+B[i]);
//        }
//        String s="";
//        for(int i=N-1;i>=0;i--){
//            s+=B[i];
//        }
//        System.out.print(s);
//    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int[] Hi=new int[N];
        int[] Mi=new int[N];
        for(int i=0;i<N;i++){
            Hi[i]=scan.nextInt();
            Mi[i]=scan.nextInt();
//            System.out.println("H:"+Hi[i]+"M:"+Mi[i]);
        }
        int X=scan.nextInt();
        int A=scan.nextInt();
        int B=scan.nextInt();
        if(B/60>0){
            A=A+B/60;
        }
        int h=0,m=0;
        if(B-X>=0){
            h=A;
            m=B-X;
        }else if(B-X+60>=0&&B-X<0){
            h=A-1;
            m=B-X+60;
        }else{
            h=A-2;
            m=B-X+120;
        }
        for(int i=0;i<N;i++){
            for (int j=0;j<N-i-1;j++){
                if(Hi[j]>Hi[j+1]){
                    int temp=Hi[j+1];
                    Hi[j+1]=Hi[j];
                    Hi[j]=temp;
                    int temp1=Mi[j+1];
                    Mi[j+1]=Mi[j];
                    Mi[j]=temp1;
                }
            }
        }
//        for (int i=0;i<N;i++){
//            System.out.println("H:"+Hi[i]+"M:"+Mi[i]);
//        }
//        System.out.println("h:"+h+" m:"+m);
        if(h<Hi[0]||(h==Hi[0]&&m<Mi[0])){
            System.out.print(0+" "+0);
        }else{
            for(int i=N-1;i>=0;i--){
                if(h==Hi[i]){
                    if(m>=Mi[i]){
                        System.out.print(Hi[i]+" "+Mi[i]);
                        break;
                    }
                }else if(h>Hi[i]){
                    System.out.print(Hi[i]+" "+Mi[i]);
                    break;
                }
            }
        }
    }
}
