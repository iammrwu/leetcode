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
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Lc_15_ThreeSum().new Solution().threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
//            return solve1(nums);
            return solve2(nums);
        }

//        private List<List<Integer>> solve3(int[] nums) {
//            List<List<Integer>> ans = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++) {
//                int target = nums[i];
//                for (int j = i+1; j < nums.length; j++) {
//                    if (nums[j] != target) {
//                        List<Integer> others = new ArrayList<>();
//                        if (others.contains(-target - nums[j])) {
//                            ans.add(Arrays.asList(target, nums[j], -target - nums[j]));
//                        } else {
//                            others.add(nums[j]);
//                        }
//                    }
//
//                }
//            }
//        }

        private List<List<Integer>> solve2(int[] nums) {
            List<Integer> numSet = new ArrayList<>();
            for (int num : nums) {
                if (!numSet.contains(num)) {
                    numSet.add(num);
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (Integer integer : numSet) {
                int target = integer;
                List<Integer> others = new ArrayList<>();
                for (Integer i : numSet) {
                    if (!i.equals(target)) {
                        if (others.contains(-target - i)) {
                            ans.add(Arrays.asList(target, i, -target - i));
                        } else {
                            others.add(i);
                        }
                    }
                }
            }
            return ans;
        }

        private List<List<Integer>> solve1(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                numSet.add(nums[i]);
            }
            List<List<Integer>> lists = new ArrayList<>();

            Iterator<Integer> iNums = numSet.iterator();
            while (iNums.hasNext()) {
                int target = iNums.next();
                Map<Integer, Integer> members = new HashMap<>();
                numSet.forEach(i -> {
                    if (!i.equals(target)) {
                        if (members.containsValue(target - i)) {
                            lists.add(Arrays.asList(members.get(i), i));
                        }
                        members.put(i, nums[i]);
                    }
                });
            }
            return lists;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}