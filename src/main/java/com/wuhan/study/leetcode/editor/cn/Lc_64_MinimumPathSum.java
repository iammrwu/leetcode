package com.wuhan.study.leetcode.editor.cn;
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 868 👎 0

import javax.sql.rowset.FilteredRowSet;
import java.util.ArrayList;
import java.util.List;

// 2021-04-30 10:47:59
public class Lc_64_MinimumPathSum {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                grid[i][0] = 1;
                grid[i][1] = 3;
                grid[i][2] = 1;
            }
            if (i == 1) {
                grid[i][0] = 1;
                grid[i][1] = 5;
                grid[i][2] = 1;
            }
            if (i == 2) {
                grid[i][0] = 4;
                grid[i][1] = 2;
                grid[i][2] = 1;
            }
        }
        System.out.println(new Lc_64_MinimumPathSum().new Solution().minPathSum(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
//            return solve1(grid);
            return solve2(grid);
        }

        private int solve1(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            return subSolve1(grid, dp);
        }

        private int subSolve1(int[][] grid, int[][] dp) {
            int mSize = grid.length;
            int nSize = grid[0].length;
            for (int m = 0; m < mSize; m++) {
                for (int n = 0; n < nSize; n++) {
                    if (m == 0 && n == 0) {
                        dp[m][n] = grid[m][n];
                    } else if (m == 0) {
                        dp[m][n] = grid[m][n] + dp[m][n - 1];
                    } else if (n == 0) {
                        dp[m][n] = grid[m][n] + dp[m - 1][n];
                    } else {
                        dp[m][n] = grid[m][n] + Math.min(dp[m - 1][n], dp[m][n - 1]);
                    }
                }
            }
            return dp[mSize - 1][nSize - 1];
        }

        private int solve2(int[][] grid) {
            int mSize = grid.length;
            int nSize = grid[0].length;
            int[] dp = new int[nSize];
            for (int i = 0; i < mSize; i++) {
                for (int j = 0; j < nSize; j++) {
                    if (i == 0 && j == 0) {
                        dp[j] = grid[i][j];
                    } else if (i == 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp[j] = dp[j] + grid[i][j];
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                    }
                }
            }
            return dp[nSize - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}