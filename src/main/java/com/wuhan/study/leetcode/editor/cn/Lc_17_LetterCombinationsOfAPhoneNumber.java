package com.wuhan.study.leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1277 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 2021-04-26 09:55:36
public class Lc_17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
//            return solve1(digits);
            return solve2(digits);
        }

        private List<String> solve2(String digits) {
            List<String> result = new ArrayList<>();
            int len = digits.length();
            if (0 == len) {
                return result;
            }
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                String str = getStr(digits.charAt(i));
                if (queue.isEmpty()) {
                    for (int j = 0; j < str.length(); j++) {
                        queue.offer(String.valueOf(str.charAt(j)));
                    }
                } else {
                    int n = queue.size();
                    for (int k = 0; k < n; k++) {
                        String currentStr = queue.poll();
                        for (int j = 0; j < str.length(); j++) {
                            queue.offer(currentStr + str.charAt(j));
                        }
                    }
                }
            }
            result.addAll(queue);
            return result;
        }

        private List<String> solve1(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.length() == 0) {
                return result;
            }
            backTrace(digits.toCharArray(), 0, result, new StringBuilder());
            return result;
        }

        private void backTrace(char[] digits, int pos, List<String> result, StringBuilder currentStr) {
            if (pos == digits.length) {
                result.add(currentStr.toString());
            } else {
                String str = getStr(digits[pos]);
                for (int i = 0; i < str.length(); i++) {
                    currentStr.append(str.charAt(i));
                    backTrace(digits, pos + 1, result, currentStr);
                    currentStr.deleteCharAt(pos);
                }
            }
        }

        private String getStr(char digit) {
            switch (digit) {
                case '2':
                    return "abc";
                case '3':
                    return "def";
                case '4':
                    return "ghi";
                case '5':
                    return "jkl";
                case '6':
                    return "mno";
                case '7':
                    return "pqrs";
                case '8':
                    return "tuv";
                case '9':
                    return "wxyz";
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}