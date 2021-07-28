package com.wuhan.study.leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3266 👎 0

import org.springframework.context.annotation.Conditional;

import java.util.*;

// 2021-04-22 11:34:32
public class Lc_15_ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        System.out.println(new Lc_15_ThreeSum().new Solution().threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
//            return solve1(nums);
//            return solve2(nums);
            return solve3(nums);
        }

        private List<List<Integer>> solve3(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums.length < 3) {
                return ans;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                if (i>0 && nums[i]== nums[i-1]) {
                    continue;
                }
                int left=i+1,right=nums.length-1;
                while (left < right) {
                    int sum=nums[i]+nums[left]+nums[right];
                    if (sum<0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }else {
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                        while (left<right &&nums[left]==nums[left-1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right +1]) {
                            right--;
                        }
                    }
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}