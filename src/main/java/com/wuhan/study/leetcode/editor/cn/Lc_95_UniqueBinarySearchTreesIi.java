package com.wuhan.study.leetcode.editor.cn;
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 动态规划 
// 👍 901 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 2021-06-18 17:53:44
public class Lc_95_UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new Lc_95_UniqueBinarySearchTreesIi().new Solution();
        List<TreeNode> ans = solution.generateTrees(1);
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class Solution {
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> ans = new LinkedList<>();
            if (n == 0) {
                return ans;
            }
            return solve1(1, n);
        }

        private List<TreeNode> solve1(int start, int end) {
            List<TreeNode> trees = new LinkedList<>();
            if (start > end) {
                trees.add(null);
                return trees;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = solve1(start, i - 1);
                List<TreeNode> rightTrees = solve1(i + 1, end);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode currentNode = new TreeNode(i);
                        currentNode.left = leftTree;
                        currentNode.right = rightTree;
                        trees.add(currentNode);
                    }
                }
            }
            return trees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}