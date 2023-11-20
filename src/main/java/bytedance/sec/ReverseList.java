package bytedance.sec;

import org.example.hot100.listNode.ListNode;

import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 14:58
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre= null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

}
