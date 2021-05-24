package com.wuhan.study.leetcode.editor.cn;
//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1059 👎 0

import java.util.PriorityQueue;

// 2021-05-06 17:09:27
public class Lc_215_KthLargestElementInAnArray {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return solve1(nums, k);
        }

        private PriorityQueue<Integer> pq = new PriorityQueue<>();

        private int solve1(int[] nums, int k) {
            KthLargest heap = new KthLargest(k, nums);
            return heap.peek();
        }
    }

    class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }

        public int peek() {
            return pq.peek();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}