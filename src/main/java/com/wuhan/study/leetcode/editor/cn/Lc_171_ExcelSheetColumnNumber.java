package com.wuhan.study.leetcode.editor.cn;
//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 字符串 
// 👍 254 👎 0

// 2021-07-30 09:34:28
public class Lc_171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        new Lc_171_ExcelSheetColumnNumber().new Solution().titleToNumber("A");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String columnTitle) {
            int ans = 0;
            int n = columnTitle.length();
            int scale = 1;
            for (int i = n - 1; i >= 0; i--) {
                char current = columnTitle.charAt(i);
                ans += getCharNum(current) * scale;
                scale *= 26;
            }
            return ans;
        }

        public int getCharNum(char column) {
            switch (column) {
                case 'A':
                    return 1;
                case 'B':
                    return 2;
                case 'C':
                    return 3;
                case 'D':
                    return 4;
                case 'E':
                    return 5;
                case 'F':
                    return 6;
                case 'G':
                    return 7;
                case 'H':
                    return 8;
                case 'I':
                    return 9;
                case 'J':
                    return 10;
                case 'K':
                    return 11;
                case 'L':
                    return 12;
                case 'M':
                    return 13;
                case 'N':
                    return 14;
                case 'O':
                    return 15;
                case 'P':
                    return 16;
                case 'Q':
                    return 17;
                case 'R':
                    return 18;
                case 'S':
                    return 19;
                case 'T':
                    return 20;
                case 'U':
                    return 21;
                case 'V':
                    return 22;
                case 'W':
                    return 23;
                case 'X':
                    return 24;
                case 'Y':
                    return 25;
                case 'Z':
                    return 26;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}