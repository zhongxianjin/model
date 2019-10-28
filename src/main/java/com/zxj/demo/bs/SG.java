package com.zxj.demo.bs;

import java.util.*;

/**
 * Created by upc on 2019/9/16.
 */
public class SG {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=M;i++){
            int Li=in.nextInt();
            int Ri=in.nextInt();
            for(int j=Li;j<=Ri;j++){
                if(map.containsKey(j)){
                    map.replace(j,i);
                }else{
                    map.put(j,i);
                }
            }
        }
        Iterator<Map.Entry<Integer,Integer>> iterator=map.entrySet().iterator();
        int sum=0;
        while (iterator.hasNext()) {
            int key = iterator.next().getKey();
            int value = map.get(key);
            sum+=key*value;
        }
        System.out.print(sum%100000009);
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        int[] array=new int[N];
        for(int i=1;i<=M;i++){
            int Li=in.nextInt();
            int Ri=in.nextInt();
            for(int j=Li;j<=Ri&&j<N;j++){
                if(i>10000009)array[j]=i%100000009;

            }
        }
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=i*array[i];
            if(sum>10000009)sum%=100000009;
        }

        System.out.print(sum%100000009);
    }


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        String[] nArray=new String[N];
        in.nextLine();
        for(int i=0;i<N;i++){
            nArray[i]=in.nextLine();
        }
        ArrayList<String> testArray=new ArrayList<>();
        for(int i=0;i<M;i++){
            testArray.add(in.nextLine());
        }
        for(int i=0;i<M-1;i++){
            if(judge(nArray,testArray.get(i))){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
        if(judge(nArray,testArray.get(M-1))){
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
    public static boolean judge(String[] nArray, String test){
        String[] testArray=test.split("\\.");
        for(int i=0;i<nArray.length;i++){
            String temp=nArray[i];
            String[] tempArray=temp.split("\\.");
            boolean flag=true;
            if(tempArray[0].equals("*")){
                for(int j=1;j<tempArray.length;j++){
                    if(!tempArray[j].equals(testArray[4-tempArray.length+j])){
                        flag=false;
                        break;
                    }
                }
                if(flag)return true;
                continue;
            }else{
                if(tempArray[tempArray.length-1].equals("*")){
                    for(int j=0;j<tempArray.length-1;j++){
                        if(!tempArray[j].equals(testArray[j])){
                            flag=false;
                            break;
                        }
                    }
                    if(flag)return true;
                    continue;
                }else{
                    for(int j=0;j<tempArray.length;j++){
                        if(!tempArray[j].equals(testArray[j])){
                            flag=false;
                            break;
                        }
                    }
                    if(flag)return true;
                    continue;
                }
            }
        }
        return false;
    }
}
