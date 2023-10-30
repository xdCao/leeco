package org.example.hot100;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/10/30 08:21
 */
public class LRUThreadSafe<K, V> {

    private int capacity;

    private ConcurrentHashMap<K, V> cacheMap;

    private ConcurrentLinkedDeque<K> deque;

    private ReentrantReadWriteLock lock;

    public LRUThreadSafe(int capacity) {
       this.capacity = capacity;
       this.cacheMap = new ConcurrentHashMap<>();
       this.deque = new ConcurrentLinkedDeque<>();
       lock = new ReentrantReadWriteLock();
    }

    public V get(K key) {
        V v = cacheMap.get(key);
        if (v == null) {
            return v;
        }
        try {
            lock.readLock().lock();
            if (deque.removeLastOccurrence(key)) {
                deque.offer(key);
            }
        } finally {
            lock.readLock().unlock();
        }
        return v;
    }

    public void put(K key, V value) {
        try {
            lock.writeLock().lock();
            if (cacheMap.containsKey(key)) {
                deque.removeLastOccurrence(key);
                deque.offer(key);
                cacheMap.put(key, value);
                return;
            }
            if (capacity < deque.size()) {
                deque.offer(key);
                cacheMap.put(key, value);
                return;
            }
            K poll = deque.poll();
            cacheMap.remove(poll);
            deque.offer(key);
            cacheMap.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
