package org.example.hot100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/30 07:55
 */
public class LRUCacheV2 {

    private int capacity;

    private Map<Integer, Node> cacheMap;

    private Node head;

    private Node tail;

    class Node {
        Node prev;
        Node next;

        int key;

        int val;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        head = new Node();
        head.next = tail;
        tail = new Node();
        tail.prev = head;
        cacheMap = new HashMap<>();
    }

    public int get(int key) {
        // 维护队列顺序
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        // 节点转移到队尾
        Node node = cacheMap.get(key);
        return moveToTail(node);
    }

    private int moveToTail(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheMap.size() < capacity || cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            if (node == null) {
                node = new Node(key, value);
                tail.prev.next = node;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev = node;
            } else {
                node.val = value;
                moveToTail(node);
            }
            cacheMap.put(key, node);
            return;
        }
        // 移除对头元素
        Node remove = head.next;
        head.next = remove.next;
        remove.next.prev = head;
        cacheMap.remove(remove.key);

        Node node = new Node(key, value);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        cacheMap.put(key, node);
    }

}
