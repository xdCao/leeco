package bytedance.sec;

import org.example.hot100.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/21 20:52
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(new ListNode(1, new ListNode(2)), 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)  {
            return null;
        }
        if (k == 1) {
            return head;
        }
        List<ListNode> parts = new ArrayList<>();
        parts.add(head);
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            cur = cur.next;
            index++;
            if (cur == null) {
                break;
            }
            if (index % (k - 1) == 0) {
                index = 0;
                ListNode next = cur.next;
                if (next == null) {
                    break;
                }
                parts.add(next);
                cur.next = null;
                cur = next;
            }
        }
        List<ListNode> reverse = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (i == parts.size() - 1 && index != 0) {
                reverse.add(parts.get(i));
            } else {
                reverse.add(doRev(parts.get(i)));
            }
        }
        for (int i = 0; i < reverse.size() - 1; i++) {
            ListNode last = getLast(reverse.get(i));
            last.next = reverse.get(i + 1);
        }
        return reverse.get(0);
    }

    private ListNode getLast(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }

    private ListNode doRev(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode next = listNode.next;
        while (true) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next == null) {
                break;
            }
            next = next.next;
        }
        return pre;
    }


}
