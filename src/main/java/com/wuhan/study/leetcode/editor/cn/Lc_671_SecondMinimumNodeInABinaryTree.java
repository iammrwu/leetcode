package com.wuhan.study.leetcode.editor.cn;
//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 170 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 2021-07-27 09:55:46
public class Lc_671_SecondMinimumNodeInABinaryTree {
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
        public int findSecondMinimumValue(TreeNode root) {
            if (null==root.left || null==root.right) {
                return -1;
            }
//            return getMin(root);
            return solve1(root);
        }

        private int getMin(TreeNode root){
            int secondVal=Integer.MAX_VALUE;
            boolean hasSecond=false;
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node=queue.poll();
                TreeNode left=node.left;
                TreeNode right=node.right;
                if (left!=null) {
                    queue.offer(left);
                    if (left.val<=secondVal && left.val> root.val) {
                        secondVal=left.val;
                        hasSecond=true;
                    }
                }
                if (node.right!=null) {
                    queue.offer(right);
                    if (right.val<=secondVal && right.val> root.val) {
                        secondVal=right.val;
                        hasSecond=true;
                    }
                }
            }
            return  hasSecond?secondVal:-1;
        }

        int ans;
        private int solve1(TreeNode root) {
           ans=-1;
           int rootVal=root.val;
           dfs(root,rootVal);
           return ans;
        }

        private void dfs(TreeNode node,int rootVal){
            if (node==null) {
                return;
            }
            if (ans!=-1&&node.val>ans) {
                return;
            }
            if (node.val>rootVal) {
                ans=node.val;
            }
            dfs(node.left,rootVal);
            dfs(node.right,rootVal);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}