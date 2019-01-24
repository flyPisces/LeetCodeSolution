package AllOneDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a data structure supporting the following operations:

 Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 Challenge: Perform all these in O(1) time complexity.

 * Created by aoshen on 11/13/16.
 */
public class  AllOne {

    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket prev;
        Bucket next;

        public Bucket(int cnt) {
            count = cnt;
            keySet = new HashSet<>();
        }
    }

    // maintain a doubly linked list of Buckets
    private Bucket head;
    private Bucket tail;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Bucket> countBucketMap;
    // keep track of count of keys
    private Map<String, Integer> keyCountMap;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            if (head.next.count != 1) {
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if (1 == count) {
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : (String) tail.prev.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
    }

    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket curBucket = countBucketMap.get(count);
        Bucket newBucket = null;

        if (countBucketMap.containsKey(count + offset)) {
            newBucket = countBucketMap.get(count + offset);
        } else {
            newBucket = new Bucket(count + offset);
            countBucketMap.put(count + offset, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.prev);
        }

        newBucket.keySet.add(key);
        removeKeyFromBucket(curBucket, key);
    }

    private void removeBucketFromList(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        bucket.prev = null;
        bucket.next = null;
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            removeBucketFromList(bucket);
            countBucketMap.remove(bucket.count);
        }
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.prev = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.prev = newBucket;
        preBucket.next = newBucket;
    }
}
