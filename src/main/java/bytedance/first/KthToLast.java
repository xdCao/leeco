package bytedance.first;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 10:50
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        ListNode cur = head;
        while (fast.next != null) {
            fast = fast.next;
            cur = cur.next;
        }
        return cur.val;
    }

}
