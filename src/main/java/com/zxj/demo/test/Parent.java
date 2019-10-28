package com.zxj.demo.test;

/**
 * Created by upc on 2019/10/7.
 */
public class Parent {
    static int i;
    int j;
    int k = methed();
    static int l = statioMethod();

    static {
//        System.out.println(100);
        System.out.println("Parent l=" + l);
    }

    {
//        System.out.println(101);
        System.out.println("Parent k=" + k);
    }

    public static int statioMethod() {
        System.out.println("Parent l=" + l);
        System.out.println("Parent i=" + i);
        return 12;
    }

    public int methed() {
        System.out.println("Parent j=" + j);
        System.out.println("Parent statioMethod" + statioMethod());
        return 4;
    }

    public Parent() {
        System.out.println("Parent");
    }
}
