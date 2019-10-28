package com.zxj.demo.bs;

import java.util.*;

/**
 * Created by upc on 2019/9/28.
 */
public class KS {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        //while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//        int n = in.nextInt();
//        int m = in.nextInt();
//        //System.out.println(a + b);
//        //}
//        in.nextLine();
//        int a[]=new int[m];
//        String[] si=new String[n];
//        for(int i=0;i<n;i++)
//         si[i]=in.nextLine();
//        String tempS[]= in.nextLine().split(" ");
//        for(int i=0;i<m;i++) a[i]=Integer.valueOf(tempS[i]);
//        int sum=0;
//        for(int i=0;i<m;i++){
//            HashMap<Character,Integer> map=new HashMap<>();
//            int A=0,B=0,C=0,D=0,E=0;
//            for(int j=0;j<n;j++){
//                if(map.containsKey(si[j].toCharArray()[i])){
//                    map.put(si[j].toCharArray()[i],map.get(si[j].toCharArray()[i])+1);
//                }else{
//                    map.put(si[j].toCharArray()[i],1);
//                }
//            }
//            Iterator<Map.Entry<Character, Integer>> iterator=map.entrySet().iterator();
//            int max=0;
//            while(iterator.hasNext()){
//                char temp=iterator.next().getKey();
//                int value=map.get(temp);
//                if(value>max){
//                    max=value;
//                }
//            }
//            sum=sum+a[i]*max;
//        }
//        System.out.print(sum);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = Integer.valueOf(in.nextLine());
        String[] b = in.nextLine().split(" ");
        if(a<1)return;
        if(a==1){
            System.out.print(b[0]);
            return ;
        }
        int array[]=new int[a];
        for(int i=0;i<a;i++){
            array[i]=Integer.valueOf(b[i]);
        }
        Arrays.sort(array);
        int index=0;
        for(int i=a-1;i>0;i--){
            if(array[i]-array[i-1]==0){
                array[i]=0;
                array[i-1]=0;
                i=i-1;
            }else if(array[i]-array[i-1]>0){
                swap(array,i);
            }
        }
        System.out.print(Math.abs(array[0]-array[1]));
    }
    public static void swap(int[] array,int index){
        int temp=array[index]-array[index-1];
        array[index]=0;
        for(int i=0;i<index;i++){
            if(temp<array[i]){
                for(int j=i;j<=index;j++){
                    int c=array[j];
                    array[j]=temp;
                    temp=c;
                }
                break;
            }else if(temp>=array[i]&&i==index-1){
                array[index-1]=temp;
            }
        }
    }
}
