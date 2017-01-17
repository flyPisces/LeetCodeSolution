package PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order,
    We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

    Given n and k, return the kth permutation sequence.
 *
 *  Created by aoshen on 4/26/16.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        k --;

        List<Integer> nums = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1;i <= n;++ i) {
            nums.add(i);
        }

        int factorial = 1;
        for (int i = 2;i < n;++ i) {
            factorial *= i;
        }
        int times = n - 1;

        while (times >= 0) {
            int index = k / factorial;

            sb.append(nums.get(index));
            nums.remove(index);

            k = k % factorial;
            if (times > 0) {
                factorial /= times;
            }else {
                factorial /= times;
            }

            times --;
        }

        return sb.toString();
    }
}
