package com.zxa.practice.leetcode.first.link;

/**
 * @author zhangxinan
 * @Classname reverseLinkList
 * @Date 2021/3/13 3:22 下午
 */
public class ReverseLinkList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
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

