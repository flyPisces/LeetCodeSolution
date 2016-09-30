package MajorityElementTwo;

import java.util.*;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

 Hint:

 How many majority elements could it possibly have?
 Do you have a better hint? Suggest it!

 * Created by aoshen on 6/22/16.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        Integer n1 = null, n2 = null;
        int c1 = 0, c2 = 0;

        for (int num : nums) {
            if (n1 != null && num == n1.intValue()) {
                c1 ++;
            } else if (n2 != null && num == n2.intValue()) {
                c2 ++;
            } else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            } else {
                c1 --;
                c2 --;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (num == n1) {
                c1 ++;
            } else if (num == n2) {
                c2 ++;
            }
        }

        if (c1 > nums.length / 3) {
            result.add(n1);
        }

        if (c2 > nums.length / 3) {
            result.add(n2);
        }

        return result;
    }
}
