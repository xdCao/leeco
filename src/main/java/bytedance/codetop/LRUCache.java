package bytedance.codetop;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 09:20
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

    private int limit;

    private Map<Integer, Node> cache;

    private Deque<Node> deque = new LinkedList<>();

    public LRUCache(int capacity) {
        this.limit = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            deque.remove(cache.get(key));
            deque.addFirst(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).val = value;
            deque.remove(cache.get(key));
            deque.addFirst(cache.get(key));
            return;
        }
        if (cache.size() == limit) {
            Node node = deque.removeLast();
            cache.remove(node.key);
        }
        cache.put(key, new Node(key, value));
        deque.addFirst(cache.get(key));
    }

    public static void main(String[] args) {
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        cache1.get(1);
        cache1.put(3, 3);
        System.out.println(cache1.get(2));


    }

}
