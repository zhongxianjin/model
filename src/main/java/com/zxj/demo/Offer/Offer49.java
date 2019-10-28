package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/13.
 */
public class Offer49 {
    /**
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
     * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     */
    Offer49() {
        System.out.println(StrToInt("-2147483648"));
    }

    public int StrToInt(String str) {
        if (str == null || str.length() <= 0) return 0;
        char[] array = str.toCharArray();
        int head = 1;
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[0] == '-') {
                head = -1;
                continue;
            }
            if (i == 0 && array[0] == '+') {
                head = 1;
                continue;
            }
            if (array[i] > '0' && array[i] < '9') {
                result += array[i];
            } else {
                return 0;
            }
        }
        if (result.equals("")) {
            return 0;
        } else {
            return (int) (head * Long.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Offer49();
    }
}
