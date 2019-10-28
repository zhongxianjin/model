package com.zxj.demo.test;

import org.junit.*;

/**
 * Created by upc on 2019/10/7.
 */
public class Children extends Parent{
    static int i;
    int j;
    int k = methed();
    static int l = statioMethod();

    static {
//        System.out.println(100);
        System.out.println("Children l="+l);
    }
    {
//        System.out.println(101);
        System.out.println("Children k="+k);
    }
    public static int statioMethod() {
        System.out.println("Children l="+l);
        System.out.println("Children i="+i);
        return 12;
    }

    public int methed() {
        System.out.println("Children j="+j);
        System.out.println("Children statioMethod"+statioMethod());
        return 4;
    }
    public Children(){
        System.out.println("Children");
    }
//    public static void main(String[] args){
//        new Children();
//    }
    @org.junit.Test
    public void test(){
//        new Children();
        new Parent();
    }
}
