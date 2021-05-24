package com.wuhan.study.leetcode.editor.cn;
//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。 
//
// 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。 
//
// 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
// 
//
// 
//
// 提示： 
//
// 
// cost 的长度范围是 [2, 1000]。 
// cost[i] 将会是一个整型数据，范围为 [0, 999] 。 
// 
// Related Topics 数组 动态规划 
// 👍 545 👎 0


import com.sun.org.glassfish.external.statistics.CountStatistic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// 2021-04-29 15:55:15
public class Lc_746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost=new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(new Lc_746_MinCostClimbingStairs().new Solution().minCostClimbingStairs(cost));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
//            return solve1(cost);
//            return solve2(cost);
//            return solve3(cost);
            return solve4(cost);
        }

        private int solve4(int[] cost){
            int n=cost.length;
            int prev1Min=cost[0],prev2Min=0;
            for (int i = 1; i < n; i++) {
                int currentMin=cost[i]+ Math.min(prev1Min,prev2Min);
                prev2Min=prev1Min;
                prev1Min=currentMin;
            }
            return Math.min(prev1Min,prev2Min);
        }

        private int solve3(int[] cost){
            // [1,100,1,1,1,100,1,1,100,1]
            int n=cost.length;
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[n];
        }



        private int solve2(int[] cost){
            int n=cost.length;
            Map<Integer,Integer> map=new HashMap();
            return Math.min(jump2(n-1,cost,map),jump2(n-2,cost,map));
        }

        private int jump2(int n,int cost[],Map<Integer,Integer> costMap){
            // [1,100,1,1,1,100,1,1,100,1]
            if (n==1 || n==0) {
                costMap.put(n,cost[n]);
                return cost[n];
            }
            int n1,n2;
            if (costMap.containsKey(n - 1)) {
                n1=costMap.get(n-1);
            }else {
                n1=jump2(n-1, cost,costMap);
                costMap.put(n-1,n1);
            }
            if (costMap.containsKey(n - 2)) {
              n2=costMap.get(n-2);
            }else {
                n2=jump2(n-2, cost,costMap);
                costMap.put(n-2,n2);
            }
            return cost[n]+ Math.min(n1,n2);
        }

        private int solve1(int[] cost) {
            int n=cost.length;
            return Math.min(jump(n-1,cost),jump(n-2,cost));
        }

        private int jump(int n,int cost[]){
            // [1,100,1,1,1,100,1,1,100,1]
            if (n==1 || n==0) {
                return cost[n];
            }
            return cost[n]+ Math.min(jump(n-1, cost),jump(n-2,cost));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}