package com.zxa.practice.leetcode.link;

/**
 * @author zhangxinan
 * @Classname SwapPairs
 * @Date 2021/3/27 9:17 下午
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {


    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode head0 = new ListNode(-1);
        ListNode pre = head0;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null && next != null){
            pre.next = next;
            ListNode temp = next.next;
            cur.next = temp;
            next.next = cur;
            pre = cur;
            cur = temp;
            if (temp != null) {
                next = temp.next;
            }
        }
        return head0.next;
    }

    public ListNode swapPairsFix(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            node1.next = node2.next;
            temp.next = node2;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;

    }


}
