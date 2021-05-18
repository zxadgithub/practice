package com.zxa.practice.leetcode.first.link;

/**
 * @author zhangxinan
 * @Classname ReverseKGroup
 * @Date 2021/5/18 7:29 下午
 */
public class ReverseKGroup {


    /**
     * 原有
     * 1 > 2 > 3 > 4 > 5
     *
     *    newhead
     *     ↓
     * 1 < 2  3 > 4 > 5
     * ↓      ↑
     * >>>>>>>
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode start = head, end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return start;
            }
            end = end.next;
        }
        ListNode newHead = reverse(start, end);
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    public ListNode reverseKGroup0(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump, end = dump;
        while(end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = reverse(start, null);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dump.next;
    }

    private ListNode reverse(ListNode head, ListNode end) {
        if (head == null) {
            return head;
        }
        ListNode pre = null, cur = head;
        while (cur != end) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
