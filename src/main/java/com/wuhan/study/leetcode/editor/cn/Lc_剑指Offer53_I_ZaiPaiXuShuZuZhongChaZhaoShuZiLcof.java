package com.wuhan.study.leetcode.editor.cn;
//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 162 👎 0

// 2021-07-16 09:44:25
public class Lc_剑指Offer53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        System.out.println(new Lc_剑指Offer53_I_ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution().search(nums,8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length==0) {
                return 0;
            }
            return solve1(nums,target,0,nums.length-1);
        }

        private int solve1(int[] nums,int target,int left,int right) {
            if (left==right) {
                return nums[left]==target?1:0;
            }
            int mid=(right-left)/2+left;
            return solve1(nums,target,left,mid)+solve1(nums,target,mid+1,right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}