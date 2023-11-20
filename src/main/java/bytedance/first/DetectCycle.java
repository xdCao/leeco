package bytedance.first;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 16:28
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        if (slow == head) {
            return head;
        }
        slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }
        return fast;
    }

}
