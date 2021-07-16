package com.wuhan.study.leetcode.editor.cn;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 586 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021-06-25 15:55:58
public class Lc_144_BinaryTreePreorderTraversal {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            preOrder(root,ans);
//            preOrder2(root,ans);
            return ans;
        }

        private void preOrder(TreeNode node,List<Integer> ans) {
            if (null==node) {
//                ans.add(null);
                return ;
            }
            ans.add(node.val);
            preOrder(node.left,ans);
            preOrder(node.right,ans);
        }

        private void preOrder2(TreeNode node,List<Integer> ans){
            if (null==node) {
                return;
            }
            Stack<TreeNode> stack=new Stack<>();
            while (null!=node || !stack.isEmpty()) {
                while (null!=node) {
                    ans.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node=stack.pop().right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}