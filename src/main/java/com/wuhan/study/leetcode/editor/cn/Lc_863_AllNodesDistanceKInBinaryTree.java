package com.wuhan.study.leetcode.editor.cn;
//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 319 👎 0

import com.wuhan.study.common.TreeNode;
import com.wuhan.study.common.TreeUtil;

import java.util.*;

// 2021-07-28 09:30:12
public class Lc_863_AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Integer[] arr=new Integer[]{3,5,1,6,2,0,8,null,null,7,4}; // 0,null,1,2,5,null,3,null,null,null,4   -- 3,5,1,6,2,0,8,null,null,7,4
        TreeNode root=TreeUtil.buildTree(arr);
        new Lc_863_AllNodesDistanceKInBinaryTree().new Solution().distanceK(root,new TreeNode(5),2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */


    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            initParent(root);
            findAns(target,null,0,k);
            return ans;
        }

        Map<Integer,TreeNode> parentMap=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        private void initParent(TreeNode root) {
            if (root.left!=null) {
                parentMap.put(root.left.val,root);
                initParent(root.left);
            }
            if (root.right!=null) {
                parentMap.put(root.right.val,root);
                initParent(root.right);
            }
        }

        private void findAns(TreeNode node,TreeNode fromNode,int step,int k){
            if (null==node) {
                return;
            }
            if (step==k) {
                ans.add(node.val);
            }
            if (node.left!=fromNode) {
                findAns(node.left,node,step+1,k);
            }
            if (node.right!=fromNode) {
                findAns(node.right,node,step+1,k);
            }
            if (parentMap.get(node.val)!=fromNode) {
                findAns(parentMap.get(node.val),node,step+1,k);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}