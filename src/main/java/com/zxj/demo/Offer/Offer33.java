package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/11.
 */
public class Offer33 {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        int t2 = 0, t3 = 0, t5 = 0;
        int array[] = new int[index];
        array[0] = 1;
        for (int i = 1; i < index; i++) {
            array[i] = Math.min(Math.min(array[t2] * 2, array[t3] * 3), array[t5] * 5);
            if (array[i] == array[t2] * 2) t2++;
            if (array[i] == array[t3] * 3) t3++;
            if (array[i] == array[t5] * 5) t5++;
        }
        return array[index - 1];
    }
}
