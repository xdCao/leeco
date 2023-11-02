package org.example.hot100.listNode;

import org.example.hot100.listNode.ListNode;

/**
 * 234. 回文链表
 * @author buku.ch
 * @Desc
 * @date 2023/10/7 23:10
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        int count = count(head);
        ListNode cur = head;
        int halfLen = count / 2;
        for (int i = 0; i < halfLen; i++) {
            cur = cur.next;
        }
        if (count % 2 == 1) {
            cur = cur.next;
        }
        // 从cur开始反转
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 比较反转后的和前半部分
        for (int i = 0; i < halfLen; i++) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
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
