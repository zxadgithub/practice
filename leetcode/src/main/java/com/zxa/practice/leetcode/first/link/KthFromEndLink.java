package com.zxa.practice.leetcode.first.link;

/**
 * @author zhangxinan
 * @Classname KthFromEndLink
 * @Date 2021/4/7 9:49 下午
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthFromEndLink {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < n - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode head){
        if (head == null){
            return head;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode cur = head, pre = head.next;
        while (pre != null){
            ListNode next = pre.next;
            pre.next = cur;
            cur = pre;
            pre = next;
        }
        return temp.next;
    }

}
