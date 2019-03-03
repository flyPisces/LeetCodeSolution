package NumberofSquarefulArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

 Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



 Example 1:

 Input: [1,17,8]
 Output: 2
 Explanation:
 [1,8,17] and [17,8,1] are the valid permutations.
 Example 2:

 Input: [2,2,2]
 Output: 1
 */
public class Solution {
    Map<Integer, Integer> countMap;
    Map<Integer, List<Integer>> squareMap;

    public int numSquarefulPerms(int[] A) {
        int N = A.length;
        countMap = new HashMap<>();
        squareMap = new HashMap<>();

        for (int num : A) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : countMap.keySet()) {
            squareMap.put(num, new ArrayList<>());
        }

        for (int x : countMap.keySet()) {
            for (int y : countMap.keySet()) {
                int r = (int)(Math.sqrt(x + y) + 0.5);
                if (r * r == x + y) {
                    squareMap.get(x).add(y);
                }
            }
        }

        int ans = 0;

        for (int x : countMap.keySet()) {
            ans += dfs(x, N - 1);
        }

        return ans;
    }

    private int dfs(int x, int todo) {
        countMap.put(x, countMap.get(x) - 1);
        int ans = 1;

        if (todo != 0) {
            ans = 0;

            for (int y : squareMap.get(x)) {
                if (countMap.get(y) != 0) {
                    ans += dfs(y, todo - 1);
                }
            }
        }

        countMap.put(x, countMap.get(x) + 1);
        return ans;
    }
}
