package org.example.hot100.listNode;

/**
 * 160. 相交链表
 * @author buku.ch
 * @Desc
 * @date 2023/10/7 22:48
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = count(headA);
        int countB = count(headB);
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < countB - countA; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int count(ListNode headA) {
        ListNode cur = headA;
        ListNode next = cur.next;
        int cnt = 1;
        while (next != null) {
            cur = next;
            next = cur.next;
            cnt++;
        }
        return cnt;
    }

}
