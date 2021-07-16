package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 614 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 2021-06-29 11:00:58
public class Lc_145_BinaryTreePostorderTraversal {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans =new ArrayList<>();
            postOrder(root,ans);
            return ans;
        }

        private void postOrder(TreeNode node, List<Integer> ans) {
            if (null==node) {
                return;
            }
            postOrder(node.left,ans);
            postOrder(node.right,ans);
            ans.add(node.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}