package com.wuhan.study.leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 868 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 2021-05-14 17:12:50
public class Lc_102_BinaryTreeLevelOrderTraversal {
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
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            return solve1(root);
        }

        private List<List<Integer>> solve1(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            if (null==root) {
                return ans;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list=new ArrayList<>();
                int size=queue.size();
                for (int i=0;i<size;i++) {
                    TreeNode treeNode= queue.poll();
                    if (null!=treeNode) {
                        list.add(treeNode.val);
                        if (null!=treeNode.left) {
                            queue.offer(treeNode.left);
                        }
                        if (null!=treeNode.right) {
                            queue.offer(treeNode.right);
                        }
                    }
                }
                ans.add(list);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}