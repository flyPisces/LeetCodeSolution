package TwoSumThreeDatastructuredesign;

import java.util.*;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false

 * Created by aoshen on 8/18/16.
 */
public class TwoSum {
    Map<Integer, Integer> tsHelper = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        if (tsHelper.containsKey(number)) {
            tsHelper.put(number, tsHelper.get(number) + 1);
        } else {
            tsHelper.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : tsHelper.entrySet()) {
            int target = value - entry.getValue();

            if (tsHelper.containsKey(target)) {
                if (target == value && tsHelper.get(target) < 2) {
                    continue;
                }

                return true;
            }
        }

        return false;
    }
}
