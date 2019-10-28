package com.zxj.demo.bs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by upczh on 2019/8/11.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int K=scan.nextInt();
        String str=scan.next();
        char[] number=str.toCharArray();
        char[] tempnumber=number;
        Arrays.sort(number);
        int count=0; char temp='0';
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<number.length;i++){
            if (map.containsKey(number[i])) {
                map.put(number[i],map.get(number[i]) + 1);
            } else {
                map.put(number[i],1);
            }

        }
        char index='0';
        for(int i=0;i<number.length;i++){
            if(count<(map.get(number[i]))){
                count=map.get(number[i]);
                temp=number[i];
                if(i>0&&count+i<N){
                    if(number[i-1]-number[i]>number[i+count]-number[i]){
                        index=number[i+count];
                    }else {
                        index=number[i-1];
                    }
                    i+=count;
                    continue;
                }else if(i>0&&count+i>=N){
                    index=number[i-1];
                    break;
                }else if(count+i>=N){
                    index=number[i];
                    break;
                }else {
                    index=number[count];
                    i+=count;
                    continue;
                }
            }
        }
        int tempcount=0;
        System.out.println("temp:"+temp+" count:"+count+" index:"+index);
        if(K<=count){
            System.out.println(0);
            System.out.println(tempnumber);
        }else {
            System.out.println((temp-index)*(K-count));
            for (int i=tempnumber.length-1;i>=0;i--){
                if(tempnumber[i]==index){
                    tempnumber[i]=temp;
                    tempcount++;
                    if(tempcount>=(temp-index)*(K-count)){
                        break;
                    }
                }
            }
            System.out.println(tempnumber);
        }
        System.out.println(index-'0');
    }
}
