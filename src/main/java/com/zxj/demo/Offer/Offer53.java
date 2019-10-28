package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer53 {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0) return false;
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (i < 1 && (str[0] == '+' || str[0] == '-' || (str[0] <= '9' && str[0] >= '0'))) {
                continue;
            }
            if (str[i] == '.') {
                if (count > 0) return false;
                else count++;
                continue;
            }
            if (str[i] == 'e' || str[i] == 'E') {
                if (i + 1 == str.length || (i + 2 == str.length && (str[i + 1] > '9' || str[i + 1] < '0')))
                    return false;
                if (i + 1 < str.length && (str[i + 1] == '+' || str[i + 1] == '-' || (str[i + 1] <= '9' && str[i + 1] >= '0'))) {
                    count++;
                    continue;
                } else {
                    return false;
                }
            }
            if (str[i] == '+' || str[i] == '-') {
                if ((str[i - 1] == 'e' || str[i - 1] == 'E') && i + 1 < str.length && (str[i + 1] <= '9' && str[i + 1] >= '0')) {
                    continue;
                } else {
                    return false;
                }
            }
            if (str[i] > '9' || str[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
