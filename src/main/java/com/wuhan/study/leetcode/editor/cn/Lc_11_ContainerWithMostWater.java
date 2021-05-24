package com.wuhan.study.leetcode.editor.cn;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2392 👎 0

// 2021-04-21 18:38:33
public class Lc_11_ContainerWithMostWater {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
//        return solve1(height);
            return solve2(height);
        }

        private int solve2(int[] height) {
            // max length = n  n-1  n-2  n-3 ...  1
            // max height(tall) = Math.min(left,right)
            // max area = length * height
            // maxArea(n) = Math.max(maxArea(n),maxArea(n-1))
            // maxArea(n-1)= Math.max( (( right -1 ) - left) * Math.min(left,right-1) , (right - (left+1)) * Math.min(left +1, right) )
            int n = height.length;
            int left = 0;
            int right = n-1;
            int max =0;;
            while (left<right) {
                max = Math.max(max,subSolve2(height,left,right));
                if (height[left]>height[right]) {
                    right--;
                }else {
                    left++;
                }
            }
            return max;
        }

        private int subSolve2(int[] array, int left, int right) {
            if (left >= right) {
                return 0;
            }
            return (right - left) * Math.min(array[left], array[right]);
        }

        private int solve1(int[] height) {
            int max = 0;
            int n = height.length;
            ;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int length = j - i;
                    int tall = Math.min(height[i], height[j]);
                    max = Math.max(max, length * tall);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}