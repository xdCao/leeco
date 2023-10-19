package org.example.hot100;

/**
 * 2. 两数相加
 * @author buku.ch
 * @Desc
 * @date 2023/10/19 18:29
 */
public class SumListNode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count1 = count(l1);
        int count2 = count(l2);
        ListNode longList = count1 >= count2 ? l1 : l2;
        ListNode shortList = count1 < count2 ? l1 : l2;

        ListNode head = null;
        ListNode merge = null;

        boolean accumulate = false;
        while (shortList != null) {
            int sum = longList.val + shortList.val + (accumulate ? 1 : 0);
            accumulate = false;
            ListNode next;
            if (sum < 10) {
                next = new ListNode(sum);
            } else {
                next = new ListNode(sum % 10);
                accumulate = true;
            }
            if (merge == null) {
                merge = next;
                head = merge;
            } else {
                merge.next = next;
                merge = next;
            }
            longList = longList.next;
            shortList = shortList.next;
        }

        while (longList != null) {
            int sum = longList.val + (accumulate ? 1 : 0);
            accumulate = false;
            ListNode next;
            if (sum < 10) {
                next = new ListNode(sum);
            } else {
                next = new ListNode(sum % 10);
                accumulate = true;
            }
            if (merge == null) {
                merge = next;
                head = merge;
            } else {
                merge.next = next;
                merge = next;
            }
            longList = longList.next;
        }


        if (accumulate) {
            merge.next = new ListNode(1);
        }
        return head;
    }

    public int count(ListNode listNode) {
        if (listNode == null) {
            return 0;
        }
        int cnt = 1;
        while (listNode.next != null) {
            cnt++;
            listNode = listNode.next;
        }
        return cnt;
    }

}
