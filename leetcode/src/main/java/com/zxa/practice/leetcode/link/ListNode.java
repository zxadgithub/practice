package com.zxa.practice.leetcode.link;

/**
 * @author zhangxinan
 * @Classname LinkNode
 * @Date 2021/3/13 3:23 下午
 */

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode build(String s){
        String[] split = s.split(",");
        ListNode head = new ListNode(Integer.parseInt(split[0]), null);
        ListNode cur = head;
        for (int i = 1; i < split.length; i++) {
            ListNode listNode = new ListNode(Integer.parseInt(split[i]), null);
            cur.next = listNode;
            cur = listNode;
        }
        return head;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}