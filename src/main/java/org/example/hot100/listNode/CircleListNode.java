package org.example.hot100.listNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/11 23:36
 */
public class CircleListNode {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        boolean has = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                has = true;
                break;
            }
        }
        if (!has) {
            return null;
        }
        if (slow == head) {
            return slow;
        }
        fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;

    }

}
