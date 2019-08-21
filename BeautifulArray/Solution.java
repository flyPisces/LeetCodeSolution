package BeautifulArray;

import java.util.*;

/**
 * For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N,
 * such that:

 For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

 Given N, return any beautiful array A.  (It is guaranteed that one exists.)



 Example 1:

 Input: 4
 Output: [2,1,4,3]
 Example 2:

 Input: 5
 Output: [3,1,2,5,4]
 */
public class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> results = new ArrayList<>();
        results.add(1);

        while (results.size() < N) {
            List<Integer> tmp = new ArrayList<>();

            for (Integer num : results) {
                if (num * 2 - 1 <= N) {
                    tmp.add(num * 2 - 1);
                }
            }

            for (Integer num : results) {
                if (num * 2 <= N) {
                    tmp.add(num * 2);
                }
            }

            results = tmp;
        }

        return results.stream().mapToInt(i -> i).toArray();
    }
}