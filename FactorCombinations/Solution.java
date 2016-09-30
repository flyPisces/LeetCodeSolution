package FactorCombinations;

import java.util.*;

/**
 * Numbers can be regarded as product of its factors. For example,

    8 = 2 x 2 x 2;
      = 2 x 4.
    Write a function that takes an integer n and return all possible combinations of its factors.

    Note:
    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.
    Examples:
    input: 1
    output:
    []
    input: 37
    output:
    []
    input: 12
    output:
    [
    [2, 6],
    [2, 2, 3],
    [3, 4]
    ]
    input: 32
    output:
    [
    [2, 16],
    [2, 2, 8],
    [2, 2, 2, 4],
    [2, 2, 2, 2, 2],
    [2, 4, 4],
    [4, 8]
    ]
 * Created by aoshen on 7/9/16.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        helper(results, result, n, 0);

        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int n, int last) {
        for (int i = 2;i < n;++ i) {
            if (n / i >= i && i >= last && n % i == 0) {
                result.add(i);
                result.add(n / i);
                results.add(new ArrayList<>(result));

                result.remove(result.size() - 1);
                helper(results, result, n / i, i);
                result.remove(result.size() - 1);
            }
        }
    }
}
