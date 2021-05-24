package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1053 👎 0

import com.wuhan.study.common.TreeNode;

// 2021-05-11 18:19:26
public class Lc_98_ValidateBinarySearchTree {
    public static void main(String[] args) {

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
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (null == root) {
                return true;
            }
            return solve1(root);
        }

        private boolean solve1(TreeNode root) {
            return subSolve1(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        private boolean subSolve1(TreeNode node, long left, long right) {
            if (null == node) {
                return true;
            }
            if (node.val <= left || node.val >= right) {
                return false;
            }
            return subSolve1(node.left, left, node.val) && subSolve1(node.right, node.val, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}