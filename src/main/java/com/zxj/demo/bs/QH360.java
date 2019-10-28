package com.zxj.demo.bs;

import java.util.Scanner;

/**
 * Created by upc on 2019/9/26.
 */
public class QH360 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int M=scan.nextInt();
        int[] array=new int[N];
        for(int i=0;i<N;i++){
            array[i]=scan.nextInt();
        }
        int start =0;
        double max=0.0,end=M;
        for(int i=0;i<N;i++){
            start=i;
            if(start+M>=N)break;
            int sum=0;
            for(int j=start;j<start+M;j++){
                sum+=array[j];
            }
            double temp=sum/1.0/(end);
            if(max<temp)max=temp;
            for(int j=start+M;j<N;j++){
                if(temp<(sum+array[j])/1.0/(end+1)){
                    max=(sum+array[j])/1.0/(end+1);
                    end++;
                }else{
                    end=M;
                    break;
                }
            }
        }
        System.out.print(String.format("%.3f",max));
    }
}
