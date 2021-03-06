package NumberofEquivalentDominoPairs;

import java.util.*;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

 Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].



 Example 1:

 Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 Output: 1

 */
public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int results = 0;

        for (int[] domino : dominoes) {
            int sum = Math.max(domino[0], domino[1]) * 10 + Math.min(domino[0], domino[1]);
            results += mapping.getOrDefault(sum, 0);
            mapping.put(sum, mapping.getOrDefault(sum, 0) + 1);
        }

        return results;
    }
}
