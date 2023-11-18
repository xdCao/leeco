package bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 01:11
 */
public class LRUCache {

    class DNode {

        int key;
        int value;
        DNode pre;
        DNode next;

        DNode() {}

        DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private int limit;

    private Map<Integer, DNode> cache = new HashMap<>();

    private DNode head;

    private DNode tail;

    public LRUCache(int capacity) {
        this.limit = capacity;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            moveHead(key);
            return cache.get(key).value;
        }
        return -1;
    }

    public void moveHead(int key) {
        DNode node = cache.get(key);
        if (node == null) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            moveHead(key);
            return;
        }
        DNode node = new DNode(key, value);
        if (cache.size() == limit) {
            removeTail();
        }
        cache.put(key, node);
        addHead(node);
    }

    public void removeTail() {
        cache.remove(tail.pre.key);
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
    }

    public void addHead(DNode node) {
        node.pre = head;
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        cache1.get(1);
        cache1.put(3, 3);
        int i = cache1.get(2);
        System.out.println(i);
    }

}
