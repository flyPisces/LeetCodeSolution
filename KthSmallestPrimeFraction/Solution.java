package KthSmallestPrimeFraction;

import java.util.*;

/**
 * A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.

 What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

 Examples:
 Input: A = [1, 2, 3, 5], K = 3
 Output: [2, 5]
 Explanation:
 The fractions to be considered in sorted order are:
 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 The third fraction is 2/5.

 Input: A = [1, 7], K = 1
 Output: [1, 7]
 */
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int N = A.length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return A[o1[0]] * A[o2[1]] - A[o1[1]] * A[o2[0]];
            }
        });

        for (int i = 0;i < N - 1;++ i) {
            pq.add(new int[] {i, N - 1});
        }

        for (int i = 0;i < K - 1;++ i) {
            int[] arr = pq.poll();

            if (arr[1] - 1 > arr[0]) {
                pq.add(new int[] {arr[0], arr[1] - 1});
            }
        }

        int[] peek = pq.peek();

        return new int[] {A[peek[0]], A[peek[1]]};
    }
}
