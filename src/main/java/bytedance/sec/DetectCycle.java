package bytedance.sec;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/21 14:44
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean meet = false;
        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meet = true;
                break;
            }
        }
        if (!meet) {
            return null;
        }
        if (slow == head) {
            return head;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
