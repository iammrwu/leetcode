package com.wuhan.study.leetcode.editor.cn;
//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 
// 👍 94 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2021-07-29 09:25:49
public class Lc_1104_PathInZigzagLabelledBinaryTree {
    public static void main(String[] args) {
        new Lc_1104_PathInZigzagLabelledBinaryTree().new Solution().pathInZigZagTree(14);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
//            return solve2(label);
            return solve1(label);
        }

        public List<Integer> solve2(int label) {
            int row = 1;
            while (label >= 1 << row) {
                row++;
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(label);
            while (label / 2 > 0) {
                label /= 2;
                label = getReverseLabel(label, --row);
                ans.add(label);
            }
            Collections.reverse(ans);
            return ans;
        }

        public List<Integer> solve1(int label) {
            int row = 1;
            while (label >= 1 << row) {
                row++;
            }
            List<Integer> ans = new ArrayList<>();
            ans.add(label);
            row--;
            while (row > 0) {
//                label /= 2;
                label=label>>1;
                label = getReverseLabel(label, row--);
                ans.add(label);
            }
            Collections.reverse(ans);
            return ans;
        }

        public int getReverseLabel(int label, int row) {
            return (1 << row) - 1 + (1 << (row - 1)) - label;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}