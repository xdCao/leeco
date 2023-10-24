package org.example.hot100;

/**
 * 24. 两两交换链表中的节点
 * @author buku.ch
 * @Desc
 * @date 2023/10/24 19:04
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = null;
        ListNode pre = null;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        if (cur2 == null) {
            return head;
        } else {
            res = head.next;
        }
        ListNode next = cur2.next;
        while (true) {
            if (pre != null) {
                pre.next = cur2;
            }
            cur2.next = cur1;
            cur1.next = next;

            if (next == null || next.next == null) {
                break;
            }

            pre = cur1;
            cur1 = next;
            cur2 = next.next;
            next = cur2.next;
        }
        return res;
    }

}
