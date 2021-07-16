package com.wuhan.study.my;

import com.wuhan.study.common.ListNodeUtil;
import com.wuhan.study.common.TreeNode;
import com.wuhan.study.common.TreeUtil;
import com.wuhan.study.leetcode.editor.cn.Lc_102_BinaryTreeLevelOrderTraversal;
import com.wuhan.study.leetcode.editor.cn.Lc_144_BinaryTreePreorderTraversal;
import com.wuhan.study.leetcode.editor.cn.Lc_95_UniqueBinarySearchTreesIi;

import java.util.List;

/**
 * @author wuhan
 * @date 2021/6/25 15:47
 */
public class TreeTest {
    public static void main(String[] args) {
        Lc_95_UniqueBinarySearchTreesIi.Solution solution95 = new Lc_95_UniqueBinarySearchTreesIi().new Solution();
//        Lc_102_BinaryTreeLevelOrderTraversal.Solution solution102=new Lc_102_BinaryTreeLevelOrderTraversal().new Solution();
        Lc_144_BinaryTreePreorderTraversal.Solution solution144=new Lc_144_BinaryTreePreorderTraversal().new Solution();
        List<TreeNode> ans = solution95.generateTrees(3);
        ans.forEach(TreeUtil::printPreOrderTree);
        System.out.println("=================================");
        ans.forEach(treeNode -> System.out.println(solution144.preorderTraversal(treeNode)));
    }
}
