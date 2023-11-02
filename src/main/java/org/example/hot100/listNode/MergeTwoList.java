package org.example.hot100.listNode;

import org.example.hot100.listNode.ListNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/12 23:10
 */
public class MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        if (list1 == null) {
            return list2;
        }
        ListNode head = list1.val <= list2.val ? list1 : list2;
        ListNode mergedCur = list1.val > list2.val ? list1 : list2;
        ListNode cur = head;

        while (mergedCur != null) {
            if (cur.next == null) {
                cur.next = mergedCur;
                break;
            }
            if (mergedCur.val < cur.next.val) {
                ListNode tmp = cur.next;
                ListNode tmp2 = mergedCur.next;
                cur.next = mergedCur;
                mergedCur.next = tmp;
                mergedCur = tmp2;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }

}
