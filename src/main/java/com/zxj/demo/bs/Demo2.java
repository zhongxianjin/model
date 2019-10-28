package com.zxj.demo.bs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Demo2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        if (expr == null || expr.equals("")) {
            return "";
        }
        char[] arrays = expr.toCharArray();
        Stack<Character> stackAll = new Stack<Character>();
        Stack<Character> stackKH = new Stack<Character>();
        for (int i = 0; i < arrays.length; i++) {
            stackAll.push(arrays[i]);
            if (arrays[i] == '(' || arrays[i] == ')')
                stackKH.push(arrays[i]);
        }
        int count=0;
        if(stackKH.size()==0){
            return expr;
        }
        while (!stackKH.isEmpty()){
            if(count<0){
                return "";
            }
            if (stackKH.peek()==')'){
                stackKH.pop();
                count=count+1;
            }else {
                stackKH.pop();
                count=count-1;
            }
        }
        if(count!=0){
            return "";
        }
        String str="";
        Stack<Character> stack=new Stack<>();
        while (!stackAll.isEmpty()) {
//            str="";
            while (stackAll.peek()!='('){
                stack.push(stackAll.pop());
            }
            stackAll.pop();
            while (stack.peek()!=')'){
                str=str+stack.pop();
            }
            stack.pop();
            str=new StringBuffer(str).reverse().toString();
//            char[] tempArray=str.toCharArray();
//            for(int i=0;i<str.length();i++){
//                stack.push(tempArray[i]);
//            }
        }
        return str;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
