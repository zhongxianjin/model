package com.zxj.demo.Offer;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by upc on 2019/9/11.
 */
public class Offer34 {
    Offer34(){
        System.out.println(FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        char[] array=str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.replace(array[i],map.get(array[i])+1);
            }else{
                map.put(array[i],1);
            }
        }
        Iterator<Character> iterator=map.keySet().iterator();
        char mark = 0;
        while(iterator.hasNext()){
            char key=iterator.next();
            int value=map.get(key);
            if(value==1){
                mark=key;
                break;
            }
        }
        int flag=-1;
        for (int i=0;i<array.length;i++){
            if(mark==array[i]){
                flag=i;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args){
        new Offer34();
    }
}
