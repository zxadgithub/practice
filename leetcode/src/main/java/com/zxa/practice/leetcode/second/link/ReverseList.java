package com.zxa.practice.leetcode.second.link;

import com.zxa.practice.leetcode.first.link.ListNode;

/**
 * @author zhangxinan
 * @Classname reversLink
 * @Date 2021/4/25 1:02 下午
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pre = head, cur = null;
        while (pre != null){
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }
        return pre;

    }
}
