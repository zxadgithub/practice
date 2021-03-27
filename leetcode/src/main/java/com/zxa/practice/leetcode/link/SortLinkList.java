package com.zxa.practice.leetcode.link;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname SortLinkList
 * @Date 2021/3/27 5:03 下午
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortLinkList {

    public static void main(String[] args) {
        SortLinkList sortLinkList = new SortLinkList();
        ListNode build = ListNode.build("4,2,1,3");
        sortLinkList.sortList(build);
    }

    public ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return mergeTwoList(left, right);

    }


    public ListNode mergeTwoList(ListNode l, ListNode r){
        if (l == null){
            return r;
        }

        if (r == null){
            return l;
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head.next;
        while (l != null && r != null){
            if (l.val > r.val){
                cur.next = r;
                r = r.next;
            } {
                cur.next = l;
                l = l.next;
            }
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return head.next;

    }

    /**
     * 偷懒写法
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if (head == null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        list.sort(Comparator.comparing(s -> s.val));
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (ListNode listNode : list) {
            listNode.next = null;
            cur.next = listNode;
            cur = listNode;
        }
        return res.next;

    }
}
