package com.zxa.practice.leetcode.first.number;

import com.zxa.practice.leetcode.first.link.ListNode;

/**
 * @author zhangxinan
 * @Classname addTwoNumbers
 * @Date 2021/3/17 9:42 下午
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head = new ListNode(-1);
        ListNode cur = head;
       int carry = 0;
       while (l1 != null && l2 != null){
           int val = l1.val + l2.val + carry;
           ListNode next = new ListNode(val % 10);
           carry = val / 10;
           cur.next = next;
           cur = cur.next;
           l1 = l1.next;
           l2 = l2.next;
       }
       while (l1 != null){
           int val = l1.val +  carry;
           ListNode next = new ListNode(val % 10);
           cur.next = next;
           cur = cur.next;
           carry = val / 10;
           l1 = l1.next;
       }
        while (l2 != null){
            int val = l2.val +  carry;
            ListNode next = new ListNode(val % 10);
            cur.next = next;
            cur = cur.next;
            carry = val / 10;
            l2 = l2.next;
        }
        if (carry != 0){
            ListNode next = new ListNode(carry);
            cur.next = next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry!=0){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            ListNode sumNode = new ListNode(sum % 10);
            cursor.next = sumNode;
            cursor = sumNode;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return root.next;

    }
}
