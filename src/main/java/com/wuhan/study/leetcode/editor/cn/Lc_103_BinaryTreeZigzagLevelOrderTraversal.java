package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 455 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.*;

// 2021-06-18 17:00:03
public class Lc_103_BinaryTreeZigzagLevelOrderTraversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            return solve1(root);
        }

        private List<List<Integer>> solve1(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            boolean isFromLeft = true;
            while (!nodeQueue.isEmpty()) {
                Deque<Integer> levelQueue = new LinkedList<>();
                int size=nodeQueue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodeQueue.poll();
                    if (null != node.left) {
                        nodeQueue.offer(node.left);
                    }
                    if (null != node.right) {
                        nodeQueue.offer(node.right);
                    }
                    if (isFromLeft) {
                        levelQueue.addLast(node.val);
                    } else {
                        levelQueue.addFirst(node.val);
                    }
                }
                isFromLeft = !isFromLeft;
                ans.add(new LinkedList<>(levelQueue));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}