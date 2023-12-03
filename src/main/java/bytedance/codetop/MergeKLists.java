package bytedance.codetop;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 18:44
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
                continue;
            }
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

}
