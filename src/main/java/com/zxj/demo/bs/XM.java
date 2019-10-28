package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by upc on 2019/9/11.
 */
public class XM {

//    /*请完成下面这个函数，实现题目要求的功能
//    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//    ******************************开始写代码******************************/
//    static String solution(String[] input) {
//        if(input==null||input.length<=0){
//            return "";
//        }
//        String result="";
//        for (int i=0;i<input.length;i++){
//            String string[]=input[i].split(" ");
//            int temp=0;
//            ArrayList<Integer> tempArray=new ArrayList<>();
//            for(int j=0;j<string.length;j++){
//                if(!string[j].equals("0"))tempArray.add(Integer.parseInt(string[j]));
//            }
//            for(int j=0;j<tempArray.size()-1;j++){
//                if(tempArray.get(j)==tempArray.get(j+1)){
//                    tempArray.set(j,2*tempArray.get(j));
//                    tempArray.remove(j+1);
//                    j=0;
//                    continue;
//                }
//            }
//            for (int j=0;j<tempArray.size();j++){
//                result+=tempArray.get(j)+" ";
//            }
//            for (int j=tempArray.size();j<string.length;j++){
//                result+=0+" ";
//            }
//            result+="\n";
//        }
//        return result;
//    }
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String res;
//
//        int _input_size = 0;
//        _input_size = Integer.parseInt(in.nextLine().trim());
//        String[] _input = new String[_input_size];
//        String _input_item;
//        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
//            try {
//                _input_item = in.nextLine();
//            } catch (Exception e) {
//                _input_item = null;
//            }
//            _input[_input_i] = _input_item;
//        }
//
//        res = solution(_input);
//        System.out.println(res);
//    }


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        int[] temp1 = new int[arr.length];
        int[] temp2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp1[i] = arr[i];
            temp2[i] = arr[i];
        }
        int count1=0,count2=0;
        for (int i = 0; i < temp1.length; i++) {
            for (int j = i + 1; j < temp1.length; j++) {
                if (temp1[i] > temp1[j]) {
                    count1++;
                    int change = temp1[j];
                    temp1[j] = temp1[i];
                    temp1[i] = change;
                }
            }
        }
        for (int i = 0; i < temp2.length; i++) {
            for (int j = i + 1; j < temp2.length; j++) {
                if (temp2[i] > temp2[j]) {
                    count2++;
                    int change = temp2[j];
                    temp2[j] = temp2[i];
                    temp2[i] = change;
                }
            }
        }

        return Math.min(count1,count2);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
