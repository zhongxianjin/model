package com.zxj.demo.bs;

import java.util.Scanner;

/**
 * Created by upc on 2019/10/14.
 */
public class XC {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {
        String[] arrayBlackIP=blackIP.split("\\.");
        String[] arrayUserIP=userIP.split("\\.");
        if(arrayBlackIP.length!=4||arrayUserIP.length!=4){
            return false;
        }
        char[] tempBlack4=arrayBlackIP[3].toCharArray();
        int children=-1;
        for(int i=0;i<tempBlack4.length;i++){
            if(tempBlack4[i]=='/'){
                String temp="";
                for(int j=i+1;j<tempBlack4.length;j++){
                    temp+=tempBlack4[j];
                }
                children=Integer.valueOf(temp);
                break;
            }
        }
        if(children==-1){
            return userIP.equals(blackIP);
        }else{
            if(children>0&&children<=8){
                int tempChildren=0;
                for(int i=0,j=7;i<children;i++,j--)tempChildren+=1<<j;
                return (Integer.valueOf(arrayUserIP[0])&(tempChildren))==(Integer.valueOf(arrayBlackIP[0])&(tempChildren));
            }else if(children>8&&children<=16){
                int tempChildren=0;
                for(int i=0,j=7;i<children-8;i++,j--)tempChildren+=1<<j;
                if(arrayUserIP[0].equals(arrayBlackIP[0]))
                    return (Integer.valueOf(arrayUserIP[1])&(tempChildren))==(Integer.valueOf(arrayBlackIP[1])&(tempChildren));
                else
                    return false;
            }else if(children>16&&children<=24){
                int tempChildren=0;
                for(int i=0,j=7;i<children-16;i++,j--)tempChildren+=1<<j;
                if(arrayUserIP[0].equals(arrayBlackIP[0])&&arrayUserIP[1].equals(arrayBlackIP[1]))
                    return (Integer.valueOf(arrayUserIP[2])&(tempChildren))==(Integer.valueOf(arrayBlackIP[2])&(tempChildren));
                else
                    return false;
            }else {
                int tempChildren=0;
                for(int i=0,j=7;i<children-24;i++,j--)tempChildren+=1<<j;
                if(arrayUserIP[0].equals(arrayBlackIP[0])&&arrayUserIP[1].equals(arrayBlackIP[1])&&arrayUserIP[2].equals(arrayBlackIP[2]))
                    return (Integer.valueOf(arrayUserIP[3])&(tempChildren))==(Integer.valueOf(arrayBlackIP[3].split("/")[0])&(tempChildren));
                else
                    return false;
            }
        }

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        int c=0;
        for(int i=0;i<6;i++){
            c+=1<<i;
        }
        System.out.println(c);
        System.out.println(c&6);
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
