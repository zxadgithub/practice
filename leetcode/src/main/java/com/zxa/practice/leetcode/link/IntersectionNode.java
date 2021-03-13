package com.zxa.practice.leetcode.link;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname IntersectionNode
 * 链表相交问题
 * @Date 2021/3/13 4:23 下午
 */
public class IntersectionNode {

    /**
     * 8
     * [4,1,8,4,5]
     * [5,6,1,8,4,5]
     * 2
     * 3
     * @param args
     */
    public static void main(String[] args) {
        ListNode headA = ListNode.build("4,1,8,4,5");
        ListNode headB = ListNode.build("5,6,1,8,4,5");
        getIntersectionNode(headA, headB);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * time1
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        int i = 0;
        while (pA != pB  ){

            if (pA.next == null && i == 1){
                return null;
            }
            if (pA.next != null){
                pA = pA.next;
            } else {
                pA = headB;
                i++;
            }

            if (pB.next != null){
                pB = pB.next;
            } else {
                pB = headA;
            }
        }
        return pA;


    }

}
