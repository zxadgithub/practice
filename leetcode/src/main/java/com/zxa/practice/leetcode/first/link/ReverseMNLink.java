package com.zxa.practice.leetcode.first.link;

/**
 * @author zhangxinan
 * @Classname ReverseMNLink
 * @Date 2021/3/14 7:56 下午
 */
public class ReverseMNLink {



    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        //虚拟节点保留
        ListNode headV = new ListNode(-1);
        headV.next = head;

        // 第left - 1
        ListNode beforeLeft = headV;
        for(int i = 0; i < left - 1 ; i++){
            beforeLeft = beforeLeft.next;
        }

        // 第right - 1
        ListNode rightNode = beforeLeft;
        for(int i = 0; i < right - left + 1 ; i++){
            rightNode = rightNode.next;
        }

        // 第left
        ListNode leftNode = beforeLeft.next;
        //第right+1
        ListNode afterRight = rightNode.next;

        //切断链表连接
        rightNode.next = null;
        beforeLeft.next = null;

        //反转第m,n
        ListNode newHead = reverseList(leftNode);

        //重新连接
        beforeLeft.next = newHead;
        leftNode.next = afterRight;
        return headV.next;

    }

    private static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return head;
    }

}
