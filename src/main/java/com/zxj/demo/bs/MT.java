package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by upc on 2019/10/16.
 */
public class MT {
    //    static AtomicInteger atomicInteger=new AtomicInteger(1);
//    static volatile char ch='C';
//    public static void main(String[] args){
//        Scanner scan=new Scanner(System.in);
//        int num=scan.nextInt();
//        StringBuffer sb=new StringBuffer("");
//        while(atomicInteger.get()<num){
//            if(atomicInteger.get()%2!=0){
//                atomicInteger.getAndIncrement();
//                sb.append('A');
//            }else{
//                if(ch=='C'){
//                    ch='B';
//                    atomicInteger.getAndIncrement();
//                    sb.append(ch);
//                }else{
//                    ch='C';
//                    atomicInteger.getAndIncrement();
//                    sb.append(ch);
//                }
//            }
//        }
//        System.out.print(sb.toString());
//
//    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] array = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        if (array.length <= 0) {
            System.out.print(0);
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        HashSet<Character> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            hashSet.add(array[i]);
            map.put(array[i], map.get(array[i]) - 1);
            if (map.get(array[i]) == 0) {
                hashSet.remove(array[i]);
            }
            if (hashSet.size() == 0) {
                arrayList.add(count);
                count = 0;
            }
        }
        for (int i = 0; i < arrayList.size() - 1; i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.print(arrayList.get(arrayList.size() - 1));
    }
}
