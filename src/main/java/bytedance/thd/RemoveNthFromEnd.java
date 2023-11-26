package bytedance.thd;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 20:01
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (true) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            slow = slow.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

}
