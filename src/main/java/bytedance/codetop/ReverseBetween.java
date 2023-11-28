package bytedance.codetop;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/28 14:09
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode leftPre = findNodeN(head, left - 1);
        if (leftPre == null) {
            return head;
        }
        ListNode leftNode = leftPre.next;
        ListNode rightNode = findNodeN(head, right);
        ListNode rightNext = rightNode.next;
        leftPre.next = null;
        rightNode.next = null;
        reverse(leftNode);
        leftPre.next = rightNode;
        leftNode.next = rightNext;
        if (left == 1) {
            return rightNode;
        }
        return head;
    }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return;
    }

    private static ListNode findNodeN(ListNode head, int left) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < left; i++) {
            cur =cur.next;
        }
        return cur;
    }

}
