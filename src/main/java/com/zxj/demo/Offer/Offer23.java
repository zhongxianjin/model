package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/27.
 */
public class Offer23 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * @param args
     */
    public static void main(String[] args) {
        int ap[] = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(ap));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        int length = sequence.length;
        int count = 0;
        --length;
        while (length > 0) {
            while (sequence[count] < sequence[length]) {
                count++;
            }
            while (sequence[count] > sequence[length]) {
                count++;
            }
            if (count < length) return false;
            count = 0;
            length--;
        }
        return true;
    }
}
