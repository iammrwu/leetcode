package com.wuhan.study.leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1586 👎 0

import java.util.HashMap;
import java.util.Map;

// 2021-04-09 11:15:31
public class Lc_70_ClimbingStairs{
    public static void main(String[] args) {
         
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> map = new HashMap();

        public int climbStairs(int n) {
            return solve3(n);
        }

        public int solve1(int n){
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int n1=0,n2=0;
            if (null != map.get(n - 1)) {
                n1=map.get(n-1);
            }else {
                n1=solve1(n-1);
                map.put(n-1,n1);
            }
            if (null != map.get(n - 2)) {
                n2=map.get(n-2);
            }else {
                n2=solve1(n-2);
                map.put(n-2,n2);
            }
            return n1 + n2;
        }

        public int solve2(int n){
            if (n < 2) {
                return 1;
            }
            Integer n0=1;
            Integer n1=1;
            Integer sum=0;
            for (int i = 2; i <= n; i++) {
                sum=n0+n1;
                n0=n1;
                n1=sum;
            }
            return sum;
        }

        public int solve3(int n){
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}