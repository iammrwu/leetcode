package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 944 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021-05-12 18:00:46
public class Lc_94_BinaryTreeInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            return solve1(root);
//            return solve2(root);
        }

        private List<Integer> solve2(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            Stack<TreeNode> stack=new Stack<>();
            while (null != root || !stack.isEmpty()) {
                while (null != root) {
                    stack.push(root);
                    root=root.left;
                }
                root=stack.pop();
                ans.add(root.val);
                root=root.right;
            }
            return ans;
        }


        private List<Integer> solve1(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            subSolve1(root,ans);
            return ans;
        }

        private void subSolve1(TreeNode node,List<Integer> ans) {
            if (null==node) {
                return;
            }
            subSolve1(node.left,ans);
            ans.add(node.val);
            subSolve1(node.right,ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}