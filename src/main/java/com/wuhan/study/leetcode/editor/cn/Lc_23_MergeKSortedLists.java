package com.wuhan.study.leetcode.editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1291 👎 0

import com.wuhan.study.common.ListNode;

import java.util.PriorityQueue;

// 2021-05-07 17:54:50
public class Lc_23_MergeKSortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
//            return solve1(lists);
//            return solve2(lists);
            return solve3(lists);
        }

        class NodeStatus implements Comparable<NodeStatus>{
            int val;
            ListNode listNode;
            NodeStatus(int val,ListNode listNode){
                this.val=val;
                this.listNode=listNode;
            }

            @Override
            public int compareTo(NodeStatus o) {
                return this.val-o.val;
            }
        }

        private ListNode solve3(ListNode[] listNodes){
            PriorityQueue<NodeStatus> queue=new PriorityQueue<>();
            for (ListNode listNode : listNodes) {
                if (null!=listNode) {
                    queue.offer(new NodeStatus(listNode.val,listNode));
                }
            }

            ListNode head=new ListNode(0);
            ListNode tail=head;
            while (!queue.isEmpty()) {
                tail.next=queue.poll().listNode;
                tail=tail.next;
                if (null!=tail.next) {
                    queue.offer(new NodeStatus(tail.next.val,tail.next));
                }
            }
            return head.next;
        }



        private ListNode solve1(ListNode[] lists) {
            ListNode ans=null;
            for (ListNode list : lists) {
                ans=mergeTwoList(ans,list);
            }
            return ans;
        }

        private ListNode solve2(ListNode[] listNodes){
            return solve2Merge(listNodes,0,listNodes.length-1);
        }

        private ListNode solve2Merge(ListNode[] listNodes,int l,int r){
            if (l==r) {
                return listNodes[l];
            }
            if (l>r) {
                return null;
            }
            int mid=(l+r)/2;
            return mergeTwoList(solve2Merge(listNodes,l,mid),solve2Merge(listNodes,mid+1,r));
        }



        private ListNode mergeTwoList(ListNode a,ListNode b){
            ListNode head=new ListNode(0);
            ListNode tail =head;
            ListNode aPos=a,bPos=b;
            while (null != aPos && null != bPos) {
                if (aPos.val > bPos.val) {
                    tail.next = bPos;
                    bPos = bPos.next;
                } else {
                    tail.next=aPos;
                    aPos=aPos.next;
                }
                tail=tail.next;
            }
            tail.next=null==aPos?bPos:aPos;
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}