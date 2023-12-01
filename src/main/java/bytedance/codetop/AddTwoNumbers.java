package bytedance.codetop;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/1 10:27
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int plus = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int tmp1 = l1 == null ? 0 : l1.val;
            int tmp2 = l2 == null ? 0 : l2.val;
            cur.next= new ListNode((tmp1 + tmp2 + plus) % 10);
            cur = cur.next;
            if (tmp1 + tmp2 + plus > 9) {
                plus = 1;
            } else {
                plus = 0;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (plus > 0) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

}
