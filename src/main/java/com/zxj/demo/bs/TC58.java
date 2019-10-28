package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by upc on 2019/10/13.
 */
public class TC58 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
//        ArrayList<Integer> arrayList=new ArrayList();
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            arrayList.add(in.nextInt());
//        }
        String str=in.nextLine();
        String[] strArray=str.split(" ");
        if(strArray.length<=1)return;
        int[] array=new int[strArray.length];
        for(int i=0;i<strArray.length;i++){
            array[i]=Integer.valueOf(strArray[i]);
        }
        strArray=null;
        Arrays.sort(array);
        int len=array.length>5?5:array.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<array.length-1;j++){
                if(array[j]<array[j+1]){
                    array[j+1]=array[j]+array[j+1];
                    array[j]=0;
                    for(int k=j+1;k<array.length-1;k++){
                        if(array[k]>array[k+1]){
                            int temp=array[k];
                            array[k]=array[k+1];
                            array[k+1]=temp;
                        }else{
                            break;
                        }
                    }
                    break;
                }else if(array[j]==array[j+1]){
                    continue;
                }else{
                    break;
                }
            }
        }
        if(array.length>5){
            System.out.print(array[5]);
        }else{
            System.out.print(array[array.length-1]);
        }
    }
}
