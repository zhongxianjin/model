package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/15.
 */
public class Offer66 {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        return judge(0, 0, threshold, rows, cols, flag);
    }

    public int judge(int i, int j, int threshold, int rows, int cols, boolean[][] flag) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] || cacul(i) + cacul(j) > threshold) {
            return 0;
        }
        flag[i][j] = true;
        return judge(i - 1, j, threshold, rows, cols, flag) + judge(i, j - 1, threshold, rows, cols, flag) +
                judge(i + 1, j, threshold, rows, cols, flag) + judge(i, j + 1, threshold, rows, cols, flag) + 1;
    }

    public int cacul(int num) {
        int sum = 0;
        while (num / 10 != 0) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }
}
