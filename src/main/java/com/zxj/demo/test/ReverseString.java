package com.zxj.demo.test;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by upc on 2019/7/21.
 */
public class ReverseString {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Stack stack=new Stack();
        System.out.println(stack.add(1));
        System.out.println(stack.add(3));
        System.out.println(stack.push(2));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.print("Please input your string : ");
//        Scanner sc = new Scanner(System.in);
        StringBuffer sc = new StringBuffer("abcdefgh");
        //迭代器
//        while(sc.hasNext()){                 //hasNext()检查序列中是否有元素，有则返true。next()获得下一个元素，返回值：元素
//            String str = sc.nextLine(); //Enter键为结束符,返回Enter键前的所有字符（可得到带空格的字符串）。next()对输入有效字符前遇到Tab键、空格键、Enter键等，会被视为结束符
        String str = sc.toString();

        System.out.println("The reversing1 string is : " + reverse1(str));  //此处变换函数
        System.out.println("The reversing2 string is : " + reverse2(str));  //此处变换函数
        System.out.println("The reversing3 string is : " + reverse3(str));  //此处变换函数
        System.out.println("The reversing4 string is : " + reverse4(str));  //此处变换函数
        System.out.println("The reversing5 string is : " + reverse5(str));  //此处变换函数
        System.out.println("The reversing6 string is : " + reverse6(str));  //此处变换函数
        System.out.println("The reversing7 string is : " + reverse7(str));  //此处变换函数
        test2();
//        }
    }

    //利用StringBuffer的内置reverse方法进行逆序排序
    public static String reverse1(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    //从头部开始,正序:通过字符串数组实现从尾部开始esrever顺序逐个进入字符串reverse
    public static String reverse2(String str) {
        int len = str.length();
        String reverse = "";        //空串。方便拼接字符串
        for (int i = 0; i < len; i++) {
            reverse = str.charAt(i) + reverse;  //charArt(int index) 返回指定索引处的字符。
        }
        return reverse;
    }

    //从尾部开始,倒序
    public static String reverse3(String str) {
        char[] arr = str.toCharArray(); //string转换成char数组
        String reverse = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];
        }
        return reverse;
    }

    //利用栈:First In Last Out
    //java中不用手动销毁
    public static String reverse4(String str) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> s = new Stack<Character>();    //创建只装字符型的stack

        for (int i = 0; i < str.length(); i++)
            s.add(str.charAt(i));

        for (int i = 0; i < str.length(); i++)
            sb.append(s.pop());                 //出栈，StringBuffer.append()添加到sb的缓冲区末端；.insert(int index,添加的内容)添加到指定位置

        return sb.toString();
    }

    //二位进制的右移，利用临时变量进行交换
    public static String reverse5(String str) {
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.length());
        System.out.println(sb.length() >>> 1);
        for (int i = 0, j = sb.length() - 1; i < sb.length() >>> 1; i++, j--) {  //右移>>
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));  //setCharAt(int index取代的位置, Char ch要替换为的字符串)
            sb.setCharAt(j, temp);

        }
        return sb.toString();
    }

    //递归
    public static String reverse6(String str) {
        int len = str.length();
        if (len <= 1)
            return str;

        String left = str.substring(0, len / 2);
        String right = str.substring(len / 2, len);

        return reverse6(right) + reverse6(left);

    }

    //异或^
    public static String reverse7(String str) {
        char[] s = str.toCharArray();
        int begin = 0;
        int end = str.length() - 1;
//        System.out.println("begin:"+s[begin]);
        while (begin < end) {
            s[begin] = (char) (s[begin] ^ s[end]);
            System.out.println("begin:" + s[begin]);
            System.out.println("end:" + s[end]);
            System.out.println("第一次^ : " + s[begin] + s[end]);
            s[end] = (char) (s[begin] ^ s[end]);     //s[begin] 被 s[end]异或两次，得到s[begin] 赋值给s[end]
            System.out.println("begin:" + s[begin]);
            System.out.println("end:" + s[end]);
            System.out.println("第二次^ : " + s[begin] + s[end]);
            s[begin] = (char) (s[end] ^ s[begin]);
            System.out.println("begin:" + s[begin]);
            System.out.println("end:" + s[end]);
            System.out.println("第三次^ : " + s[begin] + s[end]);      //换位成功
            begin++;
            end--;
        }
        return new String(s);
    }

    /**
     * 异或三次，调换顺序
     */

    public static void test2() {
        int a = 2;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ",b=" + b);
//        short a1=1;
//        short b1=2;
//        a1= (short) (a1^b1);
//        b1= (short) (a1^b1);
//        a1= (short) (a1^b1);
//        System.out.println("a1=" + a1 + ",b1=" + b1);

    }

}
