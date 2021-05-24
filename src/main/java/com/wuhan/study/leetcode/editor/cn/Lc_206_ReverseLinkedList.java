package com.wuhan.study.leetcode.editor.cn;
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1672 👎 0

import com.wuhan.study.common.ListNode;

import javax.management.ListenerNotFoundException;

// 2021-04-09 17:26:44
public class Lc_206_ReverseLinkedList {
    public static void main(String[] args) {

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
        public ListNode reverseList(ListNode head) {
            if (null==head || null==head.next) {
                return head;
            }
            return solve1(head);
        }

        private ListNode solve1(ListNode head) {
            ListNode pre=null,current=null;
            while (null != head.next) {
                current=head;
                head=head.next;
                current.next=pre;
                pre=current;
            }
            head.next=current;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}