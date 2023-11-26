package bytedance.thd;

import org.example.hot100.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 19:02
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> parts = new ArrayList<>();
        int idx = 0;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (idx % k == 0) {
                if (pre != null) {
                    pre.next = null;
                }
                parts.add(cur);
            }
            pre = cur;
            cur = cur.next;
            idx++;
        }

        boolean lastReverse = idx % k == 0;
        List<ListNode> reverse = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (i == parts.size() - 1 && !lastReverse) {
                reverse.add(parts.get(i));
            } else {
                reverse.add(reverse(parts.get(i)));
            }
        }
        for (int i = 0; i < reverse.size() - 1; i++) {
            ListNode last = getLast(reverse.get(i));
            last.next = reverse.get(i + 1);
        }
        return reverse.get(0);
    }

    private ListNode getLast(ListNode listNode) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }

    private ListNode reverse(ListNode head) {
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
        return cur;
    }


}
