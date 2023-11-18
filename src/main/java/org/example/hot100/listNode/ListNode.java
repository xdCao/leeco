package org.example.hot100.listNode;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/7 22:48
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + " " + (next == null ? "null" : next.toString());
    }
}
