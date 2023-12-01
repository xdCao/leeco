package bytedance.codetop;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/30 08:24
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode shortHead = lenA > lenB ? headB : headA;
        ListNode longHead = lenB >= lenA ? headB : headA;
        int diff = Math.abs(lenA - lenB);
        for (int i = 0; i < diff; i++) {
            longHead = longHead.next;
        }
        while (shortHead != longHead) {
            shortHead = shortHead.next;
            longHead = longHead.next;
        }
        return shortHead;
    }

    private int getLength(ListNode headA) {
        if (headA == null) {
            return 0;
        }
        int cnt = 0;
        while (headA != null) {
            headA = headA.next;
            cnt++;
        }
        return cnt;
    }

}
