package com.wuhan.study.leetcode.editor.cn;
//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 136 👎 0

import java.util.HashMap;
import java.util.Map;

// 2021-07-09 14:46:21
public class Lc_面试题17_10_FindMajorityElementLcci {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        System.out.println(new Lc_面试题17_10_FindMajorityElementLcci().new Solution().solve2(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            return solve1(nums);
        }

        private int solve2(int[] nums){
            int n=nums.length;
            if (n < 1) {
                return -1;
            }
            int count=1;
            int candidate=nums[0];
            for (int i = 1; i < n; i++) {
                if (candidate==nums[i]) {
                    count++;
                }else {
                    if (count>0) {
                        count--;
                    }else {
                        candidate=nums[i];
                        count=1;
                    }
                }
            }
            count=0;
            for (int num : nums) {
                if (num==candidate) {
                    count++;
                }
            }
            return count*2>n?candidate:-1;
        }

        private int solve1(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int n=nums.length;
            int maxCount = 0;
            int maxI = -1;
            for (int i = 0; i <n; i++) {
                int currentI=nums[i];
                int countI = 1;
                if (map.containsKey(currentI)) {
                    countI = map.get(currentI) + 1;
                }
                map.put(currentI, countI);
                if (countI > maxCount) {
                    maxCount = countI;
                    maxI = currentI;
                }
            }
            if (maxCount>n/2) {
                return maxI;
            }else {
                return -1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}