package RandomPickwithBlacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.
 *
 * Optimize it such that it minimizes the call to system’s Math.random().
 *
 * Note:
 *
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) does NOT include N. See interval notation.
 * Example 1:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * Output: [null,1,1,1]
 * Example 3:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 * Example 4:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * Output: [null,1,3,1]
 */
public class Solution {
    int M = 0;
    Map<Integer, Integer> replaceMapping;
    Random random;

    public Solution(int N, int[] blacklist) {
        random = new Random();
        M = N - blacklist.length;
        int curr = N;

        replaceMapping = new HashMap<>();
        for (int black : blacklist) {
            replaceMapping.put(black, -1);
        }
        for (int black : blacklist) {
            if (black < M) {
                while (replaceMapping.containsKey(curr - 1)) {
                    curr --;
                }
                replaceMapping.put(black, curr - 1);
                curr --;
            }
        }
    }

    public int pick() {
        int rNumber = random.nextInt(M);

        if (replaceMapping.containsKey(rNumber)) {
            rNumber = replaceMapping.get(rNumber);
        }

        return rNumber;
    }
}
