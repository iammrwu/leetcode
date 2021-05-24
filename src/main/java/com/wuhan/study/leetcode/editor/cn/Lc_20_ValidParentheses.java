package com.wuhan.study.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2313 👎 0

import java.util.*;

// 2021-04-09 11:06:20
public class Lc_20_ValidParentheses {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
//            return solve1(s);
//            return solve2(s);
            return solve3(s);
        }

        private boolean isLeft(String s) {
            return Arrays.asList("(", "[", "{").contains(s);
        }

        private boolean isLeft(Character s) {
            return Arrays.asList('(', '[', '{').contains(s);
        }

        private boolean isMatch(String left, String right) {
            return left.equals("(") && right.equals(")") || left.equals("[") && right.equals("]") || left.equals("{") && right.equals("}");
        }

        private boolean solve3(String s) {
            int n = s.length();
            if (n % 2 > 0) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty()) {
                    if (isLeft(c)) {
                        stack.push(c);
                    } else {
                        return false;
                    }
                } else {
                    if (isLeft(c)) {
                        stack.push(c);
                    } else {
                        if (!isMatch(String.valueOf(stack.pop()), String.valueOf(c))) {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean solve1(String s) {
            Stack<String> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                String str = String.valueOf(c);
                if (stack.empty()) {
                    if (isLeft(str)) {
                        stack.push(str);
                    } else {
                        return false;
                    }
                } else {
                    if (isLeft(str)) {
                        stack.push(str);
                    } else {
                        if (!isMatch(stack.pop(), str)) {
                            return false;
                        }
                    }
                }
            }

            return stack.isEmpty();
        }

        public boolean solve2(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}