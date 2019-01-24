package KnightDialer;

/**
 * A chess knight can move as indicated in the chess diagram below:
 *
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

 Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.

 How many distinct numbers can you dial in this manner?

 Since the answer may be large, output the answer modulo 10^9 + 7.



 Example 1:

 Input: 1
 Output: 10
 Example 2:

 Input: 2
 Output: 20
 Example 3:

 Input: 3
 Output: 46
 */
public class Solution {
    public static final int MOD = 1000000007;

    public int knightDialer(int N) {
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int cnt = 0;
        Integer[][] memo = new Integer[N + 1][10];

        for (int i = 0;i <= 9;++ i) {
            cnt = (cnt + dfs(N - 1, graph, i, memo)) % MOD;
        }

        return cnt;
    }

    private int dfs(int N, int[][] graph, int curr, Integer[][] memo) {
        if (0 == N) return 1;
        if (memo[N][curr] != null) return memo[N][curr];

        int cnt = 0;

        for (int neighbor : graph[curr]) {
            cnt = (cnt + dfs(N - 1, graph, neighbor, memo)) % MOD;
        }

        memo[N][curr] = cnt;

        return cnt;
    }
}
