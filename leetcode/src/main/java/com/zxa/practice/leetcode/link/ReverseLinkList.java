package com.zxa.practice.leetcode.link;

/**
 * @author zhangxinan
 * @Classname reverseLinkList
 * @Date 2021/3/13 3:22 下午
 */
public class ReverseLinkList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head, cur = null;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }

        return pre;
    }

    /**
     * 递归解
     *
     * @param head
     * @return
     */
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}

