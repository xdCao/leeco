package bytedance.first;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 09:54
 */
public class SortList {

    public static void main(String[] args) {
        ListNode listNode = sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        System.out.println(listNode);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return doSort(head);
    }

    private static ListNode doSort(ListNode head) {
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

        ListNode newHead = slow.next;
        slow.next = null;
        ListNode head1 = doSort(head);
        ListNode head2 = doSort(newHead);
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
        ListNode mergeCur = dummy;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (true) {
            if (cur1 == null) {
                mergeCur.next = cur2;
                break;
            }
            if (cur2 == null) {
                mergeCur.next = cur1;
                break;
            }

            if (cur1.val < cur2.val) {
                mergeCur.next = cur1;
                mergeCur = mergeCur.next;
                cur1 = cur1.next;
            } else {
                mergeCur.next = cur2;
                cur2 = cur2.next;
                mergeCur = mergeCur.next;
            }
        }
        return dummy.next;
    }

}
