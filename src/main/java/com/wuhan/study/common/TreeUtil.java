package com.wuhan.study.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuhan
 * @date 2021/6/30 14:34
 */
public class TreeUtil {

    public static void printPreOrderTree(TreeNode node) {
        List<String> ans = new ArrayList<>();
        preOrder(node, ans);
        System.out.println(ans);
    }

    public static void preOrder(TreeNode node, List<String> ans) {
        if (null == node) {
            ans.add("null");
            return;
        }
        ans.add(node.val + "");
        preOrder(node.left, ans);
        preOrder(node.right, ans);
    }
}
