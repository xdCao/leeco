package bytedance.fourth;

import org.example.hot100.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 16:41
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        new ReverseKGroup().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> parts = new ArrayList<>();
        int cnt = 0;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cnt % k == 0) {
                parts.add(cur);
                pre.next = null;
            }
            cnt++;
            pre = cur;
            cur = cur.next;
        }
        List<ListNode> reverseList = new ArrayList<>();
        for (int i = 0; i < parts.size(); i++) {
            if (i == parts.size() - 1 && cnt % k != 0) {
                reverseList.add(parts.get(i));
            } else {
                reverseList.add(reverse(parts.get(i)));
            }
        }
        for (int i = 0; i < reverseList.size() - 1; i++) {
            getLast(reverseList.get(i)).next = reverseList.get(i + 1);
        }
        return reverseList.get(0);
    }

    private ListNode getLast(ListNode listNode) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        return listNode;
    }

    private ListNode reverse(ListNode part) {
        ListNode pre = null;
        ListNode cur = part;
        ListNode next = part.next;
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
