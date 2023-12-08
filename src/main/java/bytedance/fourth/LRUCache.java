package bytedance.fourth;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/6 13:51
 */
public class LRUCache {

    class Node {
        int key;
        int val;

        Node() {}

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> cache;

    private Deque<Node> deque;

    private int limit;

    public LRUCache(int capacity) {
        this.limit = capacity;
        this.deque = new LinkedList<>();
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            deque.remove(node);
            deque.addFirst(node);
            return node.val;
        }
        return - 1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            deque.remove(node);
            deque.addFirst(node);
            return;
        }
        if (cache.size() == limit) {
            Node node = deque.removeLast();
            cache.remove(node.key);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        deque.addFirst(node);
    }

}
