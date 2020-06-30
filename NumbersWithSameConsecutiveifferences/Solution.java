package NumbersWithSameConsecutiveifferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

 Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

 You may return the answer in any order.



 Example 1:

 Input: N = 3, K = 7
 Output: [181,292,707,818,929]
 Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 Example 2:

 Input: N = 2, K = 1
 Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 */
public class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = new ArrayList<>();

        if (0 == N) {
            return new int[0];
        }

        if (1 == N) {
            result.add(0);
        }

        dfs(N, 0 , K, result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int N, int num, int K, List<Integer> result) {
        if (0 == N) {
            result.add(num);
            return;
        }

        for (int i = 0;i < 10;++ i) {
            if (0 == num && i == 0) continue;
            else if (num == 0 && i != 0) {
                dfs(N - 1, i, K, result);
            } else {
                if (Math.abs(num % 10 - i) == K) {
                    dfs(N - 1, 10 * num + i, K, result);
                }
            }
        }
    }
}
