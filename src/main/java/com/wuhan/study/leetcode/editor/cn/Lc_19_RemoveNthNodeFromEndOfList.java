package com.wuhan.study.leetcode.editor.cn;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1338 👎 0

import com.wuhan.study.common.ListNode;

// 2021-04-27 16:38:42
public class Lc_19_RemoveNthNodeFromEndOfList {
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (null==head) {
                return null;
            }
            if (null==head.next) {
                return null;
            }
            return solve1(head, n);
            // solve2   链表先入栈   出栈第 n 个删除
            // solve3   快慢指针，快指针笔慢指针  快 n  步
            // 定义哑结点指向头结点 （哨兵） 简化代码逻辑
        }

        private ListNode solve1(ListNode head, int n) {
            ListNode fast=head,slow=head;
            int step=1;
            while (null != fast.next && null != fast.next.next) {
                fast=fast.next.next;
                slow=slow.next;
                step++;
            }
            int length=null==fast.next?step*2-1:step*2;
            int delPos=length-n;
            if (delPos==0) {
                return head.next;
            }
            if (delPos<step)  {
                slow=head;
                step=1;
            }
            while (delPos-step > 0) {
                slow=slow.next;
                step++;
            }
            slow.next=slow.next.next;
            return head;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}