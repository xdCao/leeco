package bytedance.first;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 10:54
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
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
