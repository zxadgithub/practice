package com.zxa.practice.leetcode.first.link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname HasCircle
 * @Date 2021/3/14 5:53 下午
 */
public class HasCircle {


    public boolean hasCycle1(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while(head != null){
            if (!listNodes.add(head)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     *快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode p1 = head,p2 = head.next;
        while(p1 != p2 && p1 != null && p2 != null){
            p1 = p1.next;
            if(p2.next == null){
                return false;
            }
            p2 = p2.next.next;
        }
        if(p1 == null || p2 == null){
            return false;
        }
        return true;
    }

}
