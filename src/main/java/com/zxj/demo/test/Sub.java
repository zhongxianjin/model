package com.zxj.demo.test;

/**
 * Created by upczh on 2019/8/11.
 * 背包问题
 */
public class Sub {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 6, 10};//间隔选能组成的最大值
        System.out.println(dp_opt(arr));
        System.out.println(dp_subset(arr, 50));
        int[] arr1 = {1, 2};
        System.out.println(coin(arr1, 10));
        System.out.println(JumpFloor( 10));
        System.out.println(RectCover( 6));
    }
    public static int RectCover(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int f=1,g=2;
        while((--target)>0){
//            int temp= f;
            g=f+g;
            System.out.println("g:"+g);
            f=g-f;
            System.out.println("f:"+f);
        }
        return g;
    }
    public static int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        int sum = 0, target1 = 2, target2 = 1;
        for (int i = 3; i <= target; i++) {
            sum = target1 + target2;
            target2 = target1;
            target1 = sum;
        }
        return sum;
    }

    /**
     * 硬币组合
     */
    public static long coin(int[] arr, int number) {
        long[] d = new long[number + 1];
        d[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= number; j++) {
                d[j] += d[j - arr[i]];       //相当于
            }
        }
        System.out.println(number + "的组合方式有" + d[number] + "种");
        return d[number];
    }

    /**
     * 动态规划 间隔选能组成的最大值
     */
    public static int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            opt[i] = Math.max(opt[i - 1], opt[i - 2] + arr[i]);
        }
        return opt[arr.length - 1];
    }

    /**
     * 数组中组合数能不能组成数S,只能取一次
     *
     * @param arr
     * @param S
     * @return
     */
    public static boolean dp_subset(int[] arr, int S) {
        boolean[][] subset = new boolean[arr.length][S + 1];
        for (int i = 0; i < arr.length; i++) subset[i][0] = true;
        for (int i = 0; i < S + 1; i++) subset[0][i] = false;
        subset[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < S + 1; j++) {
                if (arr[i] > j) {
                    subset[i][j] = subset[i - 1][j];
                } else {
                    subset[i][j] = subset[i - 1][j - arr[i]] || subset[i - 1][j];
                }
            }
        }
        return subset[arr.length - 1][S];
    }

    /**
     * 0-1背包的优化解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     */
    public static int ZeroOnePack2(int V, int N, int[] weight, int[] value) {
        //动态规划
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {
            //逆序实现
            for (int j = V; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }

    /**
     * 第二类背包：完全背包
     * 思路分析：
     * 01背包问题是在前一个子问题（i-1种物品）的基础上来解决当前问题（i种物品），
     * 向i-1种物品时的背包添加第i种物品；而完全背包问题是在解决当前问题（i种物品）
     * 向i种物品时的背包添加第i种物品。
     * 推公式计算时，f[i][y] = max{f[i-1][y], (f[i][y-weight[i]]+value[i])}，
     * 注意这里当考虑放入一个物品 i 时应当考虑还可能继续放入 i，
     * 因此这里是f[i][y-weight[i]]+value[i], 而不是f[i-1][y-weight[i]]+value[i]。
     *
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public static String completePack(int V, int N, int[] weight, int[] value) {
        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);
            }
        }
        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j = V;
        String numStr = "";
        for (int i = N; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while (dp[i][j] > dp[i - 1][j]) {
                numStr = i + " " + numStr;
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        return numStr;
    }

    /**
     * 完全背包的第二种解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用顺序来实现
     */
    public static int completePack2(int V, int N, int[] weight, int[] value) {

        //动态规划
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {
            //顺序实现
            for (int j = weight[i - 1]; j < V + 1; j++) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }

    /**
     * 第三类背包：多重背包
     *
     * @param
     */
    public static int manyPack(int V, int N, int[] weight, int[] value, int[] num) {
        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i - 1], j / weight[i - 1]);
                    for (int k = 0; k < maxV + 1; k++) {
                        dp[i][j] = dp[i][j] > Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]) ? dp[i][j] : Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                    }
                }
            }
        }
        /*//则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }*/
        return dp[N][V];
    }
}
