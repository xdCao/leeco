package org.example.hot100;

/**
 * 25. K 个一组翻转链表
 * @author buku.ch
 * @Desc
 * @date 2023/10/25 21:26
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode reverseHead = getCurLast(head, k);
        if (reverseHead == head) {
            return head;
        }
        ListNode nextHead = reverseHead.next;
        reverseHead.next = null;
        doReverse(head);
        ListNode reverseLast = getRevLast(reverseHead);
        reverseLast.next = reverseKGroup(nextHead, k);
        return reverseHead;
    }

    private ListNode getRevLast(ListNode reverseHead) {
        if (reverseHead == null) {
            return null;
        }
        ListNode cur = reverseHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private ListNode getCurLast(ListNode head, int k) {
        ListNode curLast = head;
        int cnt = 1;
        while (cnt < k) {
            if (curLast.next == null) {
                return head;
            }
            curLast = curLast.next;
            cnt++;
        }
        return curLast;
    }

    private ListNode doReverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode nextNext = next.next;
            cur.next = pre;
            next.next = cur;
            pre = cur;
            cur = next;
            next = nextNext;
        }
        return cur;
    }

}
