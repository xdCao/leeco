package bytedance.codetop;

import org.example.hot100.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 18:50
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        int cnt = getCnt(head);
        List<ListNode> parts = partK(head, k);
        List<ListNode> reverse = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (i == parts.size() - 1 && cnt % k != 0) {
                reverse.add(parts.get(i));
            } else {
                reverse.add(reverse(parts.get(i)));
            }
        }
        for (int i = 0; i < reverse.size() - 1; i++) {
            getLast(reverse.get(i)).next = reverse.get(i + 1);
        }
        return reverse.get(0);
    }

    private ListNode getLast(ListNode listNode) {
        if (listNode == null) {
            return listNode;
        }
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }

    private int getCnt(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }

    private ListNode reverse(ListNode part) {
        if (part == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = part;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    private List<ListNode> partK(ListNode head, int k) {
        List<ListNode> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        res.add(head);
        ListNode cur = head;
        while (true) {
            for (int i = 0; i < k - 1; i++) {
                if (cur == null) {
                    return res;
                }
                cur = cur.next;
            }
            if (cur == null) {
                return res;
            }
            res.add(cur.next);
            cur.next = null;
            cur = res.get(res.size() - 1);
        }
    }

}
