package com.zxj.demo.Offer;

import java.util.ArrayList;

/**
 * Created by upc on 2019/8/27.
 */
public class Offer19 {

    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();  //将顺时针输出的矩阵元素都存放在结果列表里
        if (matrix.length == 0) return result;  //如果矩阵行数为0，说明是空矩阵，则直接返回空列表
        int row = matrix.length, column = matrix[0].length;  //初始化矩阵行数和列数
        if (column == 0) return result;  //如果矩阵行数不为0，矩阵的列数为0，意味着矩阵由空元素组成，依然返回空列表
        /**
         * layers是循环遍历的层数，由行和列的较小值决定，-1是为了考虑较小值为奇数的情况，
         * 除以2是因为每次循环都会因顶部从左到右和底部从右到左而用掉2行，所以只取一半，
         * +1是为了补偿之前-1造成的奇数情况下的0.5层以及偶数情况下少1层
         * */
        int layers = (Math.min(row, column) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            /**
             * 从左上到右上是从对角线元素开始，因为每上一轮的从左下到左上会多用掉1个当前行前面的元素，所以一开始j=i。
             * 遍历索引小于矩阵列数减去当前循环层数，因为前几轮从右上到右下会用掉当前行后面的元素
             * */
            for (int j = i; j < column - i; j++) result.add(matrix[i][j]);
            /**
             * 从右上到右下，因为这一轮的从左上到右上会多用掉当前列上面的1个元素，所以一开始k=i+1。
             * 遍历索引小于矩阵行数减去当前循环层数，因为前几轮从右下到左下会用掉当前列下面的元素。
             * 矩阵列的最大索引为column-1（从0开始），所以填充列表result的元素列号为列最大索引减去循环层数，因为前几轮从右上到右下会用掉当前列后几列的元素
             * */
            for (int k = i + 1; k < row - i; k++) result.add(matrix[k][column - 1 - i]);
            /**
             * 从右下到左下，矩阵列的最大索引为column-1（从0开始），因为这一轮的从右上到右下多用了一个当前行后面的元素，再结合前几轮从右上到右下用掉的后面i个元素，所以一开始j=column-1-i-1。
             * 从右下到左下过程中最后当前列的索引要大于等于循环层数，因为前几轮从左下到左上用掉了前i-1列元素，所以j>=i。
             * 同时考虑矩阵行数小于列数（如3行6列）的情况，使行的最大索引row-1（行号从0开始）减去当前循环层数不会等于当前循环层数，否则最后一轮从左上到右上之后，接下来会再重复这一轮同样元素的从右下到左下。
             * 填充列表result的元素行号为行最大索引减去循环层数，因为前几轮从右下到左下会用掉当前行下面几行的元素
             * */
            for (int j = column - 2 - i; (j >= i) && (row - 1 - i != i); j--) result.add(matrix[row - 1 - i][j]);
            /**
             * 从左下到左上，矩阵行的最大索引为row-1（从0开始），因为这一轮的从右下到左下多用了1个当前列后面的元素，再结合前几轮从左下到左上用掉的下面i个元素，所以一开始k=row-1-i-1。
             * 从左下到左上过程中最后当前行的索引要大于循环层数，和上一行的j>=i不同，这里如果有了等号最后会重复到这一轮的从左上到右上过程的第一个元素，所以k>i。
             * 同时考虑矩阵列数小于行数（如6行3列）的情况，使列的最大索引column-1减去当前循环层数不会等于当前循环层数，否则最后一轮从右上到右下后，接下来会再重复这一轮同样元素的从左下到左上。
             * 填充列表result的元素列号与当前一轮从左上到右上的开头元素的列索引相同，都为i
             * */
            for (int k = row - 2 - i; (k > i) && (column - 1 - i != i); k--) result.add(matrix[k][i]);
        }
        return result;
    }
    public ArrayList<Integer> myPrintMatrix(int [][] matrix) {
        if(matrix==null||matrix.length<1||matrix[0].length<1){return null;}
        ArrayList<Integer> result=new ArrayList<>();
        int left=0,down=0,right=0,up=0,col=matrix[0].length,row=matrix.length;
        int layer=(Math.min(col,row)-1)/2+1;
        for(int i=0;i<layer;i++){
            for(right=i;right<col-i;right++)result.add(matrix[i][right]);
            for(down=i+1;down<row-i;down++)result.add(matrix[down][right-1]);
            for(left=right-2;left>=i&& (row - 1 - i != i);left--)result.add(matrix[down-1][left]);
            for(up=down-2;up>i && (col - 1 - i != i);up--)result.add(matrix[up][left+1]);
        }
        return result;
    }
}
