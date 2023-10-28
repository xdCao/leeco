package org.example.hot100;

/**
 * 148. 排序链表
 * 写起来还是容易被绕进去
 * @author buku.ch
 * @Desc
 * @date 2023/10/27 07:55
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4,
                new ListNode(19,
                        new ListNode(14,
                                new ListNode(
                                        5,
                                        new ListNode(-3,
                                                new ListNode(
                                                        1,
                                                        new ListNode(
                                                                6,
                                                                new ListNode(
                                                                        5,
                                                                        new ListNode(
                                                                                11,
                                                                                new ListNode(
                                                                                        15,
                                                                                        null
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                ))
                                )
                        ))
        );
        SortList sortList = new SortList();
        ListNode listNode = sortList.sortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 断开链表
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null) {
            quick = quick.next.next;
            if (quick == null) {
                break;
            }
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode head = left.val < right.val ? left : right;
        ListNode mergeCur = head;
        ListNode leftCur = left == head ? left.next : left;
        ListNode rightCur = right == head ? right.next : right;
        while (leftCur != null && rightCur != null) {
            if (leftCur.val < rightCur.val) {
                mergeCur.next = leftCur;
                leftCur = leftCur.next;
            } else {
                mergeCur.next = rightCur;
                rightCur = rightCur.next;
            }
            mergeCur = mergeCur.next;
        }
        if (leftCur == null) {
            mergeCur.next = rightCur;
        }
        if (rightCur == null) {
            mergeCur.next = leftCur;
        }
        return head;
    }


}
