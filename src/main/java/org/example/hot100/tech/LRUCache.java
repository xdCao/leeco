package org.example.hot100.tech;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * @author buku.ch
 * @Desc
 * @date 2023/10/29 13:53
 */
public class LRUCache {

    private int capacity;

    private LinkedHashMap<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        // 维护队列顺序
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        return refreshKeyOrder(key);
    }

    public void put(int key, int value) {
        if (cacheMap.size() < capacity || cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            refreshKeyOrder(key);
            return;
        }
        Iterator<Integer> iterator = cacheMap.keySet().iterator();
        cacheMap.remove(iterator.next());
        cacheMap.put(key, value);
    }

    private Integer refreshKeyOrder(int key) {
        Integer oldVal = cacheMap.remove(key);
        cacheMap.put(key, oldVal);
        return oldVal;
    }

}
