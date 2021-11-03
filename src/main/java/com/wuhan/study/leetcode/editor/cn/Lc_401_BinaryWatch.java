package com.wuhan.study.leetcode.editor.cn;
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 
// 👍 314 👎 0

import java.util.ArrayList;
import java.util.List;

// 2021-08-06 17:26:16
public class Lc_401_BinaryWatch {
    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            System.out.println(i + " : " + Integer.bitCount(i));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
//            return solve1(turnedOn);
            return solve2(turnedOn);
        }

        private List<String> solve2(int turnedOn) {
            List<String> ans = new ArrayList<String>();
            for (int i = 0; i < 1024; ++i) {
                int h=i>>6,m=i&63;
                if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
            return ans;
        }

        private List<String> solve1(int turnedOn) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                        ans.add(i + ":" + (j < 10 ? "0" + j : j));
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}