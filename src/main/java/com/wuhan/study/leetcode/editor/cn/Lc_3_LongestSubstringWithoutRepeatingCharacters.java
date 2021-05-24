package com.wuhan.study.leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5304 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2021-04-13 11:16:41
public class Lc_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // abcacbbb
            if (s.length()<1) {
                return 0;
            }
            if (s.length()==1) {
                return 1;
            }
            return solve1(s);
        }

        private int solve1(String s) {
            int length=s.length();
            int maxLen=1;
            int start=0;
            Map<Character,Integer> have=new HashMap<>();
            have.put(s.charAt(start),start);
            for (int i = 1; i < length; i++) {
                Character currentChar=s.charAt(i);
                if (have.containsKey(currentChar)) {
                    start=have.get(currentChar)+1;
                    have.clear();
                    for (int j = start; j < i; j++) {
                        have.put(s.charAt(j),j);
                    }
                }else {
                    maxLen= Math.max(i-start+1, maxLen);
                }
                have.put(currentChar,i);
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}