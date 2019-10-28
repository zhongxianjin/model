package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by upc on 2019/9/1.
 */
public class TX {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[] ai=new int[n];
        int countMax=0;
        for(int i=0;i<n;i++){
            ai[i]=scan.nextInt();
        }
        int count=1,temp=m;
        for(int i=0;i<n;i++){
            if(m-ai[i]>=0){
                count++;
                m=m-ai[i];
            }else{
                ai[i]=ai[i]-m;
                m=temp;
                i--;
                count++;
            }
        }

        System.out.println(count);
    }
    public static void main1(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[] ai=new int[n];
        int[] bj=new int[m];
        for(int i=0;i<n;i++){
            ai[i]=scan.nextInt();
        }
        ArrayList<Integer> b=new ArrayList<Integer>();
        for(int j=0;j<m;j++){
            bj[j]=scan.nextInt();
            b.add(bj[j]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<b.size();j++){
                if((ai[i]+b.get(j))%2!=0){
                    b.remove(j);
                    break;
                }
            }
        }
        System.out.print(m-b.size());
    }
    public static void main3(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int[] ai=new int[n];
        int countMax=0;
        for(int i=0;i<n;i++){
            ai[i]=scan.nextInt();
        }
        int count=1,temp=m;
        for(int i=0;i<n;i++){
            if(m-ai[i]>=0){
                count++;
                m=m-ai[i];
            }else{
                ai[i]=ai[i]-m;
                m=temp;
                i--;
                count++;
            }
        }

        System.out.println(count);

    }
    public static void main4(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] ai=new int[n];
        int countMax=0;
        for(int i=0;i<n;i++){
            ai[i]=scan.nextInt();
        }
        int min=ai[0],max=0;
        for(int i=0;i<n;i++){
            min=ai[i];
            for(int j=i;j<n;j++){
                if(min>ai[j]){
                    min=ai[j];
                }
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=ai[k];
                }
                if(max<min*sum){
                    max=min*sum;
                }
            }

        }
        System.out.println(max);

    }
}
