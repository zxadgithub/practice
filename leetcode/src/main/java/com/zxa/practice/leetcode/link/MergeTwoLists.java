package com.zxa.practice.leetcode.link;

/**
 * @author zhangxinan
 * @Classname MergeTwoLists
 * @Date 2021/3/13 8:13 下午
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }

    /**
     * 很神奇的写法~
     * @param l1
     * 我们可以如下递归地定义两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
     * list1[0]+merge(list1[1:],list2)
     * list2[0]+merge(list1,list2[1:])
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else  {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 新链表，指向最小的一个每次连接
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
              cur.next = l2;
              l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;

    }


}
