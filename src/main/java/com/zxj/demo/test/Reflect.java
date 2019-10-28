package com.zxj.demo.test;

import java.lang.reflect.*;
import java.util.*;

/**
 * Created by upc on 2019/8/19.
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class classInfo=Class.forName(com.zxj.demo.test.testlist.List.class.getName());
        System.out.println(ArrayList.class.getName());
        System.out.println("Vector的构造函数：");
        Constructor con[]=classInfo.getConstructors();
        for(int i=0;i<con.length;i++){
            System.out.println(con[i].toString());
        }
        System.out.println("Vector的方法:");
        Method method[]=classInfo.getMethods();
        for(int i=0;i<method.length;i++){
            System.out.println(method[i]);
        }
    }
}
