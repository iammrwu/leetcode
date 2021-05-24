package com.wuhan.study.leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 709 👎 0

import java.util.List;

// 2021-04-30 10:07:47
public class Lc_131_PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            return solve1(s);
        }

        private List<List<String>> solve1(String s) {
            // fasdfasdfasdgasdg
            // aab
            int n=s.length();
            for (int i = 0; i < n; i++) {

            }
            return null;
        }

        private void isPalindrome(String s,int begin,int end,List<String> strList){
            if (begin>=0 && end<=s.length() && begin<=end) {

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}