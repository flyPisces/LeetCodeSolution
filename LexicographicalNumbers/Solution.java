package LexicographicalNumbers;

import java.util.*;

/**
 * Given an integer n, return 1 - n in lexicographical order.

 For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

 Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

 * Created by aoshen on 8/26/16.
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> results = new ArrayList<>();

        if (n <= 0) {
            return results;
        }

        helper(results, n, 0);
        return results;
    }

    public void helper(List<Integer> results, int n, int curr) {
        if (curr > n) {
            return;
        }

        if (curr != 0) {
            results.add(curr);
        }

        int start = curr == 0 ? 1 : 0;
        int end = 9;

        for (int i = start;i <= end;++ i) {
            helper(results, n, 10 * curr + i);
        }
    }
}
