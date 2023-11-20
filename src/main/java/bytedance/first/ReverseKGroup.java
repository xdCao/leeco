package bytedance.first;

import org.example.hot100.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 20:58
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        reverseKGroup(new ListNode(1, new ListNode(2)), 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> tmp = new ArrayList<>();
        ListNode pre = null;
        ListNode cur = head;
        boolean complete = true;
        while (cur != null) {
            tmp.add(cur);
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    complete = false;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            if (pre != null) {
                pre.next = null;
            }
        }
        List<ListNode> tmp2 = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            if (i == tmp.size() - 1 && !complete) {
                tmp2.add(tmp.get(i));
            } else {
                tmp2.add(reverse(tmp.get(i)));
            }
        }
        for (int i = 0; i < tmp2.size() - 1; i++) {
            getLast(tmp2.get(i)).next = tmp2.get(i + 1);
        }
        return tmp2.get(0);
    }

    private static ListNode getLast(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }
}

