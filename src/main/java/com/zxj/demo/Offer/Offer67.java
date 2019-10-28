package com.zxj.demo.Offer;

/**
 * Created by upc on 2019/9/15.
 */
public class Offer67 {
    /**
     * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if(target<2)return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        int x = target % 3;
        int y = target / 3;
        if (x == 0) {
            return (int) Math.pow(3, y);
        } else if (x == 1) {
            return (int) Math.pow(3, y - 1) * 2 * 2;
        } else {
            return (int) Math.pow(3, y) * 2;
        }
    }
    /**
     *动态规划求解问题的四个特征：
     *①求一个问题的最优解；
     *②整体的问题的最优解是依赖于各个子问题的最优解；
     *③小问题之间还有相互重叠的更小的子问题；
     *④从上往下分析问题，从下往上求解问题；
     *
     *贪婪解法： 当n大于等于5时，我们尽可能多的剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
     *为什么选2，3为最小的子问题？因为2，3包含于各个问题中，如果再往下剪得话，乘积就会变小。
     *为什么选长度为3？因为当n≥5时，3(n−3)≥2(n−2)
     */


    public int cutRopeDP(int target) {
        //动态规划:长度为i的可得最大乘积:dp[i]=dp[j]*dp[i-j]的最大值
        if(target<2) return 0;  //可以不写这行
        if(target==2) return 1;
        if(target==3) return 2;
        int[] dp=new int[target+1];
        //边界值
        dp[0]=0;dp[1]=0;dp[2]=2;dp[3]=3;

        for(int i=4;i<=target;i++){
            int max=0;
            for(int j=1;j<=i/2;j++){
                if(max<(dp[j]*dp[i-j])){
                    max=dp[j]*dp[i-j];
                }
            }
            dp[i]=max;
        }
        return dp[target];

    }
}
