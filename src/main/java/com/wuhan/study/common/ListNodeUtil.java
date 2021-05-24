package com.wuhan.study.common;

/**
 * @author wuhan
 * @date 2021/4/9 15:42
 */
public class ListNodeUtil {

    public static ListNode getLsitNode(int[] array){
        if (null==array || array.length<1) {
            return new ListNode(0);
        }
        ListNode l=new ListNode(array[0]);
        if (array.length>1) {
            ListNode currnetNode=l;
            for (int i = 1; i < array.length; i++) {
                currnetNode.next=new ListNode(array[i]);
                currnetNode=currnetNode.next;
            }
        }
        return l;
    }

    public static void printListNode(ListNode l){
        if (null==l) {
            return;
        }
        while (null != l) {
            System.out.print(l.val+",");
            l=l.next;
        }
        System.out.println();
    }
}
