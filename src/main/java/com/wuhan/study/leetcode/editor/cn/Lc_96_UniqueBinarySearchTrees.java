package com.wuhan.study.leetcode.editor.cn;
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 动态规划 
// 👍 1138 👎 0

// 2021-04-29 15:12:25
public class Lc_96_UniqueBinarySearchTrees {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int[] dp=new int[n+1];
            dp[0]=1;
            dp[1]=1;
            for (int i = 2; i <= n; i++) {
                for (int root = 1; root <= i; root++) {
                    dp[i] +=dp[root-1] * dp[i-root];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}