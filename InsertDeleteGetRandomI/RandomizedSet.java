package InsertDeleteGetRandomI;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements.
 Each element must have the same probability of being returned.
 Example:

 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 1 is the only number in the set, getRandom always return 1.
 randomSet.getRandom();

 * Created by aoshen on 8/20/16.
 */
public class RandomizedSet {
    Map<Integer, Integer> map1;
    Map<Integer, Integer> map2;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map1.containsKey(val)) {
            return false;
        } else {
            map1.put(val, map1.size());
            map2.put(map2.size(), val);
        }

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map1.containsKey(val)) {
            int index = map1.get(val);

            map1.remove(val);
            map2.remove(index);

            if (map1.size() == 0) {
                return true;
            }

            if (map1.size() == index) {
                return true;
            }

            int key1 = map2.get(map2.size());

            map1.put(key1, index);
            map2.remove(map2.size());
            map2.put(index, key1);
        } else {
            return false;
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (map1.size() == 0) {
            return -1;
        }

        return map2.get(random.nextInt(map2.size()));
    }
}
