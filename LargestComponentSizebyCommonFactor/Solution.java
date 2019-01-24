package LargestComponentSizebyCommonFactor;

import java.util.*;

/**
 * Given a non-empty array of unique positive integers A, consider the following graph:

 There are A.length nodes, labelled A[0] to A[A.length - 1];
 There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
 Return the size of the largest connected component in the graph.


 */
public class Solution {
    int max = 0;

    public int largestComponentSize(int[] A) {
        boolean[] isPrimes = new boolean[100001];
        Arrays.fill(isPrimes, true);
        Set<Integer> primes = new HashSet<>();

        for (int i = 2;i <= 100000;++ i) {
            if (isPrimes[i]) {
                primes.add(i);
                for (int j = 2;i * j <= 100000;++ j) {
                    isPrimes[i * j] = false;
                }
            }
        }

        int N = A.length;
        int[] counts = new int[N];
        int[] parent = new int[N];
        int[] primeIndex = new int[100001];

        Arrays.fill(counts, 1);
        Arrays.fill(primeIndex, -1);

        for (int i = 0;i < N;++ i) {
            parent[i] = i;
        }

        for (int i = 0;i < N;++ i) {
            int a = A[i];

            for (int prime : primes) {
                if (primes.contains(a)) {
                    prime = a;
                }

                if (a % prime == 0) {
                    if (primeIndex[prime] > -1) {
                        union(parent, counts, primeIndex[prime], i);
                    }
                        primeIndex[prime] = i;
                        while (a % prime == 0) {
                            a /= prime;
                        }

                }

                if (a == 1) break;
            }
        }
        return max;
    }

    private int find(int[] parent, int a) {
        if (a != parent[a]) {
            parent[a] = find(parent, parent[a]);
        }

        return parent[a];
    }

    private void union(int[] parent, int[] count, int a, int b) {
        int root1 = find(parent, a), root2 = find(parent, b);

        if (root1 == root2) return;

        int sum = count[root1] + count[root2];
        max = Math.max(max, sum);
        parent[root1] = root2;
        count[root2] = sum;
    }
}
