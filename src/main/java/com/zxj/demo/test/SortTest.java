package com.zxj.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by upc on 2019/8/12.
 */
public class SortTest {
    public static int countGB = 0;

    public static void main(String[] args) {
        int[] array = {1, 12, 8, 9, 6, 8, 4, 7, 2, 3, 5, 4, 6, 0};
        long startTime = System.currentTimeMillis();    //获取开始时间

//        int[] array1 = MP(array);//冒泡排序
//        int[] array1 = XZ(array);//选择排序
//        int[] array1 = CR(array);//插入排序
//        int[] array1 = XE(array);//希尔排序
//        int[] array1 = GB(array);//归并排序
//        System.out.println(countGB);//归并排序循环次数 54 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
//        KS(array, 0, array.length - 1);//快速排序
//        System.out.println(countGB);//快速排序循环次数 46 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        int[] array1 = D(array);//堆排序
//        System.out.println(countGB);//堆排序循环次数 49 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
        int[] array1 = JS(array);//计数排序

//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        for (int i = 0; i < array.length; i++) {
//            arrayList.add(array[i]);
//        }
//        ArrayList array1 = T(arrayList, 10);//桶排序 556次，速度太慢了，循环次数太多了 最佳情况：T(n) = O(n+k)   最差情况：T(n) = O(n+k)   平均情况：T(n) = O(n2)　k是桶的个数，选bucketSize也很重要，对于不同数组选取不一样的bucketSize区别很大
//        for (int i = 0; i < array1.size(); i++) {
//            System.out.print(array1.get(i) + " ");
//        }
//        System.out.println();
//        System.out.println(countGB);

//        int[] array1=basket(array);//桶排序
//        int[] array1 = radix(array);//基数排序
//        int[] array1 = RadixSort(array);//基数排序

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] MP(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag++;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        System.out.println(count);//91 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
        return arr;
    }

    /**
     * 选择排序
     *
     * @param arr
     * @return
     */
    public static int[] XZ(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        long startTime = System.currentTimeMillis();    //获取开始时间
//        /**
//         * TODO:这里使用的方法需要一直替换数组内的值，会破坏原来的数组,但是没关系
//         */
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                count++;
                if (arr[i] > arr[j]) {
                    int change = arr[j];
                    arr[j] = arr[i];
                    arr[i] = change;
                }
            }
        }
//        /**
//         * TODO:这里使用的方法除了将最小值和未排序列的第一个值作交换外，不破坏未排序序列的顺序
//         */

//        for(int i=0;i<arr.length;i++){
//            int minIndex=i;
//            for(int j=i;j<arr.length;j++){
//                count++;
//                if(arr[minIndex]>arr[j]){
//                    minIndex=j;
//                }
//            }
//            int temp=arr[minIndex];
//            arr[minIndex]=arr[i];
//            arr[i]=temp;
//        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(count);//1、91 2、105 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr
     * @return
     */
    public static int[] CR(int[] arr) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        if (arr.length <= 1) {
            return arr;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {//往后移动，只要i+1的这个值比前面已经排好序的小，就把前面的值往后移动一个位置（原理：因为前面已经排好序了，只要找到第一个比自己小的那个位置放到那个后面就行了）
                count++;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(count);//61 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
        return arr;
    }

    /**
     * 希尔排序
     * 插入排序升级版
     *
     * @param arr
     * @return
     */
    public static int[] XE(int[] arr) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        if (arr.length <= 1) {
            return arr;
        }
        int gap = arr.length / 2;
        int count = 0;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 && arr[j + gap] < arr[j]; j = j - gap) {
                    count++;
                    int temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
            gap /= 2;

        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(count);//19 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
        return arr;
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static int[] GB(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        return merge(GB(Arrays.copyOfRange(arr, 0, arr.length / 2)), GB(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
    }

    /**
     * 合并左右数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            countGB++;
            if (i >= left.length) {
                result[index] = right[j++];// <=> result[index]=right[j];j++;
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @return
     */
    public static void KS(int[] arr, int left, int right) {
        if (arr.length <= 1) return;
        if (left > right) {
            return;
        }
        int i = left, j = right, key = arr[left];
        while (i < j) {
            while (i < j && arr[j] > key) {//从右往左找第一个比key值小的数，找到后退出循环，这样保留j的值，这个arr[j]就是第一个小于key的值
                countGB++;
                j--;
            }
            while (i < j && arr[i] <= key) {//从左往右找第一个比key值大的数，找到后退出循环，保留i的值，用来替换从右边找的第一个小于key的值，这样两个对调之后相当于以key为中心，左边为小于key的值，右边为大于key的值
                countGB++;
                i++;
            }
            if (i < j) {//对调，对调后arr[i]为小于key的值，arr[j]为大于key的值
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];//将key值与小于key的值对调，这样key的左边就是小于key的，右边是大于key的
        arr[i] = key;//现在第i个为key了，后面只需要对key的左右两边进行快排就可以了
//        System.out.println("i:"+i);
        KS(arr, left, i - 1);// 对key左边的数快排
        KS(arr, i + 1, right);// 对key右边的数快排
    }

    /**
     * 堆排序
     *
     * @param arr
     * @return
     */
    public static int[] D(int[] arr) {
        if (arr.length <= 1) return arr;
        for (int i = 0; i < arr.length; i++) {
            buildMaxD(arr, arr.length - i);//从最后一个开始，每次建堆把最后一个位置存放最大值达到排序的目的
            int temp = arr[0];
            arr[0] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    /**
     * 建堆
     *
     * @param arr
     * @param currentRootNode 当前父节点位置（数组小标）
     * @param size            节点总数
     */
    public static void buildD(int[] arr, int currentRootNode, int size) {
//        System.out.print(currentRootNode + ":" + size);
        if (currentRootNode < size) {
            //左子树和右字数的位置
            int leftChildNode = 2 * currentRootNode + 1;
            int rightChildNode = 2 * currentRootNode + 2;
            //假设节点是最大值节点的位置，max用来记录最大值的位置
            int max = currentRootNode;
            if (leftChildNode < size) {
                if (arr[leftChildNode] > arr[max]) {//如果左节点大于当前记录的值，将记录的位置换成当前位置
                    max = leftChildNode;
                }
            }
            if (rightChildNode < size) {
                if (arr[rightChildNode] > arr[max]) {//如果右节点大于当前记录的值，将记录的位置换成当前位置
                    max = rightChildNode;
                }
            }
            if (max != currentRootNode) {//将当前父节点的位置上的值，与记录的最大值位置的值进行对调，这样当前父节点位置的值就大于子节点了
                int temp = arr[currentRootNode];
                arr[currentRootNode] = arr[max];
                arr[max] = temp;
            }
//            System.out.println(":" + max);
        }
    }

    /**
     * 构建最大堆
     *
     * @param arr
     * @param size
     */
    public static void buildMaxD(int[] arr, int size) {
        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size / 2 - 1; i >= 0; i--) {//这里初始值为啥是size/2-1呢，因为要从第一个非叶子节点开始查起，最后一个叶子节点如果是左子树，它的值为2x+1，x为父节点位置，size-1=2x+1 =>x=size/2 -1
            //最后一个叶子节点如果是右子树，它的值为2x+2，x为父节点位置，size-1=2x+2 =>x=size/2 -3/2 所以取x=size/2-1临界值，能够保证第一个父节点不会漏掉，也能避免多余的循环
            buildD(arr, i, size);
            countGB++;
        }
    }

    /**
     * 计数排序
     *
     * @param arr
     * @return
     */
    public static int[] JS(int[] arr) {
        if (arr.length <= 1) return arr;
        int bias, min = arr[0], max = arr[0];
        int count = 0;
        for(Integer i:arr){
            System.out.println(i);
        }
        System.out.println("*****************************");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
            count++;
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] + bias]++;
            count++;
        }

//        int index=0,k=0;
//        while (index<arr.length){
//            if(bucket[k]!=0){
//                arr[index]=k-bias;
//                bucket[k]--;
//                index++;
//            }else {
//                k++;
//            }
//            count++;
//        }

        for (int i = 0, j = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[j] = i - bias;
                j++;
                bucket[i]--;
                count++;
            }
        }
        System.out.println(count);//计数排序循环次数 1、53 2、41  T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
        return arr;
    }

    /**
     * 桶排序
     * 计数排序的升级版
     * 桶排序是计数排序的变种，它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。把计数排序中相邻的m个”小桶”放到一个”大桶”中，在分完桶后，对每个桶进行排序（一般用快排），然后合并成最后的结果。
     *
     * @param arr
     * @param bucketSize 人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）；
     * @return
     */
    public static ArrayList<Integer> T(ArrayList<Integer> arr, int bucketSize) {
        if (arr == null || arr.size() <= 1)
            return arr;
        int max = arr.get(0), min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            countGB++;
            if (max < arr.get(i)) {
                max = arr.get(i);
            }
            if (min > arr.get(i)) {
                min = arr.get(i);
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList> bucketArr = new ArrayList(bucketCount);
        ArrayList resultArr = new ArrayList();
        for (int i = 0; i < bucketCount; i++) {
            countGB++;
            bucketArr.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.size(); i++) {
            countGB++;
            bucketArr.get((arr.get(i) - min) / bucketSize).add(arr.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    countGB++;
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList temp = T(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    countGB++;
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    /**
     * 进阶版桶排序，通过整数的位数来计算 来源于百度百科
     *
     * @param data
     * @return
     */
    public static int[] basket(int data[])//data为待排序数组
    {
        if (data.length < 2) {
            return data;
        }
        int count = 0;
        int n = data.length;
        int bask[][] = new int[10][n];
        int index[] = new int[10];
        int max = Integer.toString(data[0]).length();
        for (int i = 0; i < n; i++) {
            count++;
            max = max > (Integer.toString(data[i]).length()) ? max : (Integer.toString(data[i]).length());
        }
        String str;
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                str = "";
                if (Integer.toString(data[j]).length() < max) {
                    for (int k = 0; k < max - Integer.toString(data[j]).length(); k++) {
                        str += "0";
                        count++;
                    }
                } else {
                    count++;
                }
                str += Integer.toString(data[j]);
                bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = data[j];
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < index[j]; k++) {
                    count++;
                    data[pos++] = bask[j][k];
                }
            }
            for (int x = 0; x < 10; x++) {
                count++;
                index[x] = 0;
            }
        }
        System.out.println(count);//循环次数 90 ，当数组内的值最大最小值之差变大时循环次数会增加很多很多，当不同位数的值比较多时，循环次数增加，比如 1 10 100 1000
        return data;
    }

    /**
     * 基数排序
     * 最佳情况：T(n) = O(n * k)   最差情况：T(n) = O(n * k)   平均情况：T(n) = O(n * k) 来源于百度百科
     *
     * @param number
     * @return
     */
    public static int[] radix(int[] number) {
        if (number.length < 2) {
            return number;
        }
        int count = 0;
        int d = 0;//d表示最大的数有多少位
        for (int i = 0; i < number.length; i++) {
            count++;
            d = d > Integer.toString(number[i]).length() ? d : Integer.toString(number[i]).length();
        }

        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9  第二维的数组下标表示这个余数重复的个数
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                count++;
                int lsd = ((number[i] / n) % 10);//除以位数值（1 100 1000）再对10取余得到第m位的个位数的值
                temp[lsd][order[lsd]] = number[i];//表示当前余数LSD第 order[lsd]重复的那个数是number[i]
                order[lsd]++;//当前位数的个位数的值的个数 （比如129 当m=2时，当前位数为2，当前位数的个位数是(129/10)%10等于2 如果还有一个321，那么order[2]++的值就是两个了
            }
            for (int i = 0, k = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        count++;
                        number[k] = temp[i][j];
                        k++;
                    }
                } else {
                    count++;
                }
                order[i] = 0;
            }
            n *= 10;
            m++;
        }
        System.out.println(count);//循环次数78次
        return number;
    }

    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        int count = 0;
        // 1.先算出最大数的位数；
        int maxDigit = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            maxDigit = maxDigit > Integer.toString(array[i]).length() ? maxDigit : Integer.toString(array[i]).length();
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            count++;
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                count++;
                int num = (array[j] % mod) / div;//获取第maxDigit位的个位数
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    count++;
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        System.out.println(count);//循环次数80
        return array;
    }
}
