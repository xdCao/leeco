package org.example.hot100;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author buku.ch
 * @Desc
 * @date 2023/10/23 18:37
 */
public class DeleteRevNListNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return head.next;
        }
        ListNode realCur = head;
        while (cur.next != null) {
            cur = cur.next;
            realCur = realCur.next;
        }
        realCur.next = realCur.next == null ? null : realCur.next.next;
        return head;

    }

}
