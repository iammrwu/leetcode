package com.wuhan.study.leetcode.editor.cn;
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 935 👎 0

import com.wuhan.study.common.ListNode;
import com.wuhan.study.common.ListNodeUtil;

// 2021-04-09 14:59:55
public class Lc_234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new Lc_234_PalindromeLinkedList().new Solution();
        ListNode listNode = ListNodeUtil.getLsitNode(new int[]{1, 2, 2, 1});
        ListNodeUtil.printListNode(listNode);
        solution.isPalindrome(listNode);
        ListNodeUtil.printListNode(listNode);
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (null == head || null == head.next) {
                return true;
            }
            return solve1(head);
        }

        private boolean solve1(ListNode head) {
            ListNode p1 = head, p2 = head;
            ListNode pre = null, current = null;
            while (null != p2 && null != p2.next) {
                current = p1;
                p2 = p2.next.next;
                p1 = p1.next;
                current.next = pre;
                pre = current;
            }
            pre=p1;
            if (null != p2) {
                p1 = p1.next;
            }
            while (null != p1) {
                if (p1.val != current.val) {
                    return false;
                } else {
                    current.next=pre;
                    p1 = p1.next;
                    current =head;
                }
            }
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}