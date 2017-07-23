package LFUCache;

import java.util.*;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present.
 When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
 For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
 the least recently used key would be evicted.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LFUCache cache = new LFUCache( 2  capacity  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 * Created by aoshen on 1/4/17.
 */

public class LFUCache {

    private int capacity = 0;
    private int min = -1;
    private Map<Integer, Integer> vals;
    private Map<Integer, Integer> counts;
    private Map<Integer, LinkedHashSet<Integer>> lists;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        min = -1;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if (counts.get(key) == null) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);

        lists.get(count).remove(key);

        if (count == min && lists.get(count).isEmpty()) {
            min ++;
            lists.remove(count);
        }

        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);

        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() == capacity) {
            int keyToRemove = lists.get(min).iterator().next();
            vals.remove(keyToRemove);
            counts.remove(keyToRemove);

            lists.get(min).remove(keyToRemove);
            if (lists.get(min).isEmpty()) {
                lists.remove(min);
            }
        }

        min = 1;
        if (!lists.containsKey(min)) {
            lists.put(min, new LinkedHashSet<>());
        }
        vals.put(key, value);
        counts.put(key, min);
        lists.get(min).add(key);
    }
}
