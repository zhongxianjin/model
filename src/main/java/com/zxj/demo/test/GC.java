package com.zxj.demo.test;

/**
 * Created by upc on 2019/9/18.
 */
public class GC {
    public static void main(String[] args){
        System.gc();

        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");    //系统的最大空间

        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");   //系统的空闲空间

        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");   //当前可用的总空间
//        Thread
    }
}
