package org.example.hot100.listNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 * @author buku.ch
 * @Desc
 * @date 2023/10/26 22:55
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> cache = new HashMap<>();
        Node cur = head;
        Node copyHead = new Node(head.val);
        Node copyCur = copyHead;
        cache.put(cur, copyHead);
        while (cur.next != null) {
            cur = cur.next;
            Node tmp = new Node(cur.val);
            copyCur.next = tmp;
            copyCur = tmp;
            cache.put(cur, copyCur);
        }
        copyCur = copyHead;
        cur = head;
        while (copyCur != null) {
            copyCur.random = cache.get(cur.random);
            copyCur = copyCur.next;
            cur = cur.next;
        }
        return copyHead;
    }

}
