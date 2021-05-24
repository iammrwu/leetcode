package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1374 👎 0

import com.wuhan.study.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 2021-05-14 11:01:05
public class Lc_101_SymmetricTree {
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
        public boolean isSymmetric(TreeNode root) {
            return solve1(root);
//            return solve2(root);
        }

        private boolean solve2(TreeNode root) {
            if (null==root) {
                return true;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode t1=queue.poll();
                TreeNode t2=queue.poll();
                if (null==t1 && null==t2) {
                    continue;
                }
                if (null==t1 || null==t2 || t1.val!=t2.val) {
                    return false;
                }
                queue.offer(t1.left);
                queue.offer(t2.right);
                queue.offer(t1.right);
                queue.offer(t2.left);
            }
            return true;
        }

        private boolean solve1(TreeNode root) {
            if (null==root) {
                return true;
            }
            return subSolve1(root.left,root.right);
        }

        private boolean subSolve1(TreeNode t1,TreeNode t2){
            if (null==t1 && null==t2) {
                return true;
            }
            if (null==t1 || null==t2 || t1.val!=t2.val) {
                return false;
            }

            return subSolve1(t1.left,t2.right) && subSolve1(t1.right,t2.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}