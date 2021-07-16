package com.wuhan.study.leetcode.editor.cn;
//给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。 
//
// h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别
//被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）" 
//
// 
//
// 示例: 
//
// 输入: citations = [0,1,3,5,6]
//输出: 3 
//解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
//     由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。 
//
// 
//
// 说明: 
//
// 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。 
//
// 
//
// 进阶： 
//
// 
// 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。 
// 你可以优化你的算法到对数时间复杂度吗？ 
// 
// Related Topics 数组 二分查找 
// 👍 136 👎 0

// 2021-07-12 15:32:35
public class Lc_275_HIndexIi{
    public static void main(String[] args) {
        int[] citations=new int[]{0,0,0};
        System.out.println(new Lc_275_HIndexIi().new Solution().hIndex(citations));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        return solve1(citations,0, citations.length-1);
    }

        private int solve1(int[] citations,int left,int right) {
            int len= citations.length;
            if (left==right) {
                return citations[left]>len-(left+1)?len-left:len-(left+1);
            }
            int mid= (right-left)/2+left;
            int midV= citations[mid];
            if (midV>=len-mid) {
                return solve1(citations,left,mid-1);
            }else {
                return solve1(citations,mid,right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}