package com.zxj.demo.bs;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by upczh on 2019/8/31.
 */
public class XL {
    public int count=0;
    public Queue queue=new LinkedList();
    public HashMap<Integer,Integer> map=new HashMap<>();
    public XL(int capacity) {
        count=capacity;
    }

    public int get(int key) {
        if(queue.size()<=0)return -1;
        if(map.containsKey(key)){
            queue.poll();
            queue.offer(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public String getMinVersion(String[] list) {
        if(list==null||list.length<=0){
            return null;
        }
        // 在这里编写代码
        int temp=0,index=0,min=Integer.valueOf(list[0].split(".")[0]);
        int[] indexArray=new int[list.length];
        for(int i=0;i<list.length;i++){
            String[] str=list[i].split(".");
            int tem=Integer.valueOf(str[0]);;
           if(min>tem){
               min=tem;
               index=i;
           }
           if(min==tem){

           }
        }
        return null;
    }
}
