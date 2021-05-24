package com.wuhan.study.leetcode.editor.cn;
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 435 👎 0

import com.wuhan.study.LeetcodeApplication;

// 2021-04-29 15:32:09
public class Lc_392_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new Lc_392_IsSubsequence().new Solution().isSubsequence("abc",           "ahbgdc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            return solve1(s, t);
        }

        private boolean solve1(String s, String t) {
            return contain(s,t,0);
        }

        private boolean contain(String s,String t,int sPos){
            if (sPos>=s.length()) {
                return true;
            }
            int pos=t.indexOf(String.valueOf(s.charAt(sPos)));
            if (pos>=0) {
                return contain(s,t.substring(pos+1),sPos+1);
            }else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}