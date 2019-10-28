package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer35 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
    int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        GB(array, 0, array.length - 1);
        return count;
    }

    public void GB(int[] array, int start, int end) {
        if (start >= end) return;
        GB(array, start, (end + start) / 2);
        GB(array, (end + start) / 2 + 1, end);
        merge(array, start, (start + end) / 2, end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int temp[] = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (array[i] > array[j]) {
                if (count >= 1000000007)
                    count %= 1000000007;
                count += mid - i + 1;
                temp[k++] = array[j++];
            } else {
                temp[k++] = array[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for (i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
