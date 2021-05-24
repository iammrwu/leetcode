package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 435 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.*;

// 2021-05-14 17:38:32
public class Lc_107_BinaryTreeLevelOrderTraversalIi {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            return solve1(root);
//            return solve2(root);
        }

        private List<List<Integer>> solve2(TreeNode root) {
            List<List<Integer>> levelOrder = new LinkedList<>();
            if (root == null) {
                return levelOrder;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    TreeNode left = node.left, right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
                levelOrder.add(0, level);
            }
            return levelOrder;
        }

        private List<List<Integer>> solve1(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (null == root) {
                return ans;
            }
            Stack<List<Integer>> stack = new Stack<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (null != treeNode) {
                        list.add(treeNode.val);
                        if (null != treeNode.left) {
                            queue.offer(treeNode.left);
                        }
                        if (null != treeNode.right) {
                            queue.offer(treeNode.right);
                        }
                    }
                }
                stack.push(list);
            }
            while (!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}