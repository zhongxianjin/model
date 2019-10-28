package com.zxj.demo.bs;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by upc on 2019/9/10.
 */
public class BLBL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            String b = in.nextLine();
//        }
        int max=Math.max(a.length(),b.length());
        int count=0;
        char[] achar=a.toCharArray();
        char[] bchar=b.toCharArray();
        Stack<Character> astack=new Stack<>();
        Queue<Character> aq=new LinkedList<>();
        for(int i=0;i<achar.length;i++){
            aq.offer(achar[i]);
            astack.push(achar[i]);
        }
        for(int i=bchar.length-1;i>=0;i--){
            if(astack.peek()==bchar[i]){
                astack.pop();
            }
        }
        for(int i=0;i<bchar.length;i++){
            if(aq.peek()==bchar[i]){
                aq.poll();
            }
        }
        if(achar.length>bchar.length){
            for(int i=0;i<bchar.length;i++){
                if(aq.peek()==bchar[i]){
                    aq.poll();
                }
            }
            count=count+(achar.length-bchar.length);
        }else if(achar.length==bchar.length){
            for(int i=0;i<achar.length;i++){
                if(achar[i]!=bchar[i])count++;
            }
        }else{
            for(int i=0;i<achar.length;i++){
                if(achar[i]!=bchar[i])count++;
            }
            count=count+(bchar.length-achar.length);
        }
        System.out.print(count);
    }
}
