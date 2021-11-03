package com.wuhan.study.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static TreeNode buildTree(Integer[] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1; i < arr.length; i++){
            TreeNode node = queue.peek();
            TreeNode son = arr[i] == null? null:new TreeNode(arr[i]);
            if((i&1) == 1){
                if(node != null)
                    node.left = son;
            } else{
                if(node != null)
                    node.right = son;
                queue.poll();
            }
            queue.add(son);
        }
        return root;
    }
}
