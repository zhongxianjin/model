package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/8/21.
 */
public class Offer6 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length < 1) {
            return 0;
        }
        int left = 0, right = array.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
                continue;
            }
            if (array[mid] == array[right]) {
                right = right - 1;
                continue;
            }
            if (array[mid] < array[right]) {
                right = mid;
                continue;
            }
        }
        return array[left];
    }
}
