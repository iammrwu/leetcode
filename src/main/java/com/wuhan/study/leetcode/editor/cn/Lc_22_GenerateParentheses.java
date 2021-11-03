package com.wuhan.study.leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1754 👎 0

import java.util.ArrayList;
import java.util.List;

// 2021-04-28 11:27:57
public class Lc_22_GenerateParentheses {
    public static void main(String[] args) {
        new Lc_22_GenerateParentheses().new Solution().generateParenthesis(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            return solve2(n);
        }
        public List<String> solve2(int n){
            List<String> ans = new ArrayList<String>();
            backtrace(ans,"",n,n);
            return ans;
        }

        public void backtrace(List<String> ans,String cur,int left,int right){
            if (left==0 && right==0) {
                ans.add(cur.toString());
                return;
            }
            if (left ==right) {
                backtrace(ans, cur+"(", left - 1, right);
            } else {
                if (left>0) {
                    backtrace(ans,cur+"(",left-1,right);
                }
                backtrace(ans,cur+")",left,right-1);
            }
        }


        public List<String> solve1(int n){
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}