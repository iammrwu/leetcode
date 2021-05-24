package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 682 👎 0

import com.wuhan.study.common.TreeNode;

import javax.xml.stream.FactoryConfigurationError;

// 2021-05-14 17:52:16
public class Lc_110_BalancedBinaryTree {
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
        public boolean isBalanced(TreeNode root) {
            return solve1(root);
//            return solve2(root);
        }

        private boolean solve2(TreeNode root) {
            if (null==root) {
                return true;
            }
            return subSolve2(root)>=0;
        }

        private int  subSolve2(TreeNode treeNode){
            if (null==treeNode) {
                return 0;
            }
            int leftDepth=subSolve2(treeNode.left);
            int rightDepth=subSolve2(treeNode.right);
            if (leftDepth==-1 || rightDepth==-1 || Math.abs(leftDepth-rightDepth)>1 ) {
                return -1;
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }

        private boolean solve1(TreeNode root) {
            if (null == root) {
                return true;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            return Math.abs(leftDepth - rightDepth) <= 1 && solve1(root.left) && solve1(root.right);
        }

        private int getDepth(TreeNode treeNode) {
            if (null == treeNode) {
                return 0;
            }
            if (null == treeNode.left && null == treeNode.right) {
                return 1;
            }
            return Math.max(getDepth(treeNode.left), getDepth(treeNode.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}