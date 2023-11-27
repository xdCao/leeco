package bytedance.thd;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/27 11:18
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                break;
            }
            slow = slow.next;
        }

        ListNode subHead = slow.next;
        slow.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(subHead);
        return merge(head1, head2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null || head2 != null) {
            if (head1 == null) {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
                continue;
            }
            if (head2 == null) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
                continue;
            }

            if (head1.val < head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        return dummy.next;
    }

}
