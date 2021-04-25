package com.zxa.practice.leetcode.first.link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname DetectCycle
 * @Date 2021/3/28 5:48 下午
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCycle {

    /**
     * hash表完成
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return head;
        }
        Set<ListNode> set = new HashSet<>();
        int i = 0;
        while (head != null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;

    }

    /**
     * 快慢指针
     * 当快慢指针相遇时候
     * 假设head到环口为a, 相遇点 - 环口 距离为b，相遇点还需要c才再能到环口,,
     * 如下图，相遇点在7，则a = 1,b = 4 ,c = 2
     * 1，2，4，6，7,8
     *    ↑
     * 则此时s(fast)  = a + b + n(b + c) = a + (n+1)b + nc,  s(slow) = a + b, s(fast) = 2s(slow)
     * 既a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * 既我们会发现：从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离 若n = 1,则a = c。
     * 既相遇时，另一指针restart 走到环口的距离  = slow走到环口的距离
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode restart = head;
                while (restart != slow){
                    slow = slow.next;
                    restart = restart.next;
                }
                return restart;
            }

        }
        return null;
    }

}
