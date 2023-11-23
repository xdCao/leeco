package bytedance.sec;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/23 11:36
 */
public class SortList {

    public static void main(String[] args) {
        ListNode listNode = sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        System.out.println(listNode);
    }

    public static ListNode sortList(ListNode head) {
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

    private static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                dummy.next = head2;
                dummy = dummy.next;
                head2 = head2.next;
                continue;
            }
            if (head2 == null) {
                dummy.next = head1;
                dummy = dummy.next;
                head1 = head1.next;
                continue;
            }
            if (head1.val < head2.val) {
                dummy.next = head1;
                dummy = dummy.next;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                dummy = dummy.next;
                head2 = head2.next;
            }
        }
        return head.next;
    }

}
