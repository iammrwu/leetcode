package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 877 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 2021-05-14 10:31:57
public class Lc_104_MaximumDepthOfBinaryTree {
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
        public int maxDepth(TreeNode root) {
//            return solve1(root);
            return solve2(root);
        }

        private int solve2(TreeNode root) {
            if (null==root) {
                return 0;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            int ans=0;
            while (!queue.isEmpty()) {
                int size=queue.size();
                while (size > 0) {
                    TreeNode node=queue.poll();
                    if (null!=node.left) {
                        queue.offer(node.left);
                    }
                    if (null!=node.right) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }

        private int solve1(TreeNode root) {
            if (null==root) {
                return 0;
            }
            int maxDep=1;
            return subSolve1(root,maxDep);
        }
        private int subSolve1(TreeNode root,int max){
            if (null==root.left && null==root.right) {
                return max;
            }
            if (null==root.left) {
                return subSolve1(root.right,max+1);
            }
            if (null==root.right) {
                return subSolve1(root.left,max+1);
            }
            return  Math.max(subSolve1(root.left,max+1),subSolve1(root.right,max+1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}