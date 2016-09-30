package LRUCache;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 * Created by aoshen on 7/6/16.
 */
public class LRUCache {

    public class DoubleLinkedListNode {
        int key;
        int value;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
    }

    private int capacity;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    Map<Integer, DoubleLinkedListNode> mapping;


    public LRUCache(int capacity) {
        head = null;
        tail = null;
        mapping = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int res = -1;

        if (mapping.containsKey(key)) {
            DoubleLinkedListNode target = mapping.get(key);

            remove(target);
            setHead(target);

            res = target.value;
        }

        return res;
    }

    public void set(int key, int value) {
        if (mapping.containsKey(key)) {
            DoubleLinkedListNode target = mapping.get(key);
            target.value = value;

            remove(target);
            setHead(target);
        } else {
            DoubleLinkedListNode target = new DoubleLinkedListNode();
            target.key = key;
            target.value = value;

            if (capacity <= mapping.size()) {
                mapping.remove(tail.key);
                remove(tail);
                setHead(target);
            } else {
                setHead(target);
            }

            mapping.put(key, target);
        }
    }

    private void remove(DoubleLinkedListNode node) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    private void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }
}
