package com.wuhan.study.leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1092 👎 0

import com.wuhan.study.common.TreeNode;
import com.wuhan.study.common.TreeUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 2021-06-30 14:18:47
public class Lc_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
//        int[] order=Arrays.copyOfRange(preorder,1,5);
//        System.out.println(order);
        TreeNode treeNode = new Lc_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution().buildTree(preorder, inorder);
        TreeUtil.printPreOrderTree(treeNode);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
//            return solve1(preorder, inorder);
//            return solve2(preorder, inorder);
            return solve3(preorder, inorder);
        }

        private TreeNode solve1(int[] preorder, int[] inorder) {
            if (preorder.length < 1 || inorder.length < 1) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            for (int i = 0; i < inorder.length; i++) {
                if (root.val == inorder[i]) {
                    root.left = solve1(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                    root.right = solve1(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                }
            }
            return root;
        }

        private TreeNode solve2(int[] preorder, int[] inorder) {
            if (preorder.length < 1 || inorder.length < 1) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
//            int i = Arrays.binarySearch(inorder, root.val);
            List<Integer> arr=Arrays.stream(inorder).boxed().collect(Collectors.toList());
            int i =arr.indexOf(root.val);
            root.left = solve2(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
            root.right = solve2(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            return root;
        }

        private TreeNode solve3(int[] preorder, int[] inorder) {
            Map<Integer,Integer> inorderMap=new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i],i);
            }
            int n = preorder.length;
            return subSolve3(preorder,inorder ,0, n - 1, 0, n - 1,inorderMap);
        }

        private TreeNode subSolve3(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right,Map<Integer,Integer> indexMap) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = subSolve3(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1,indexMap);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = subSolve3(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right,indexMap);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}