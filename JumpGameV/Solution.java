package JumpGameV;

import sun.security.x509.EDIPartyName;

/**
 *
 Given an array of integers arr and an integer d. In one step you can jump from index i to index:

 i + x where: i + x < arr.length and 0 < x <= d.
 i - x where: i - x >= 0 and 0 < x <= d.
 In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

 You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.

 Notice that you can not jump outside of the array at any time.
 */
public class Solution {

    private int dfs(int[] arr, int[] dp, int d, int i) {
        if (dp[i] > 0) return dp[i];

        int result = 1;

        for (int j = i + 1;j <= Math.min(i + d, arr.length - 1) && arr[i] > arr[j];++ j) {
            result = Math.max(result, 1 + dfs(arr, dp, d, j));
        }

        for (int j = i - 1;j >= Math.max(0, i - d) && arr[i] > arr[j];-- j) {
            result = Math.max(result, 1 + dfs(arr, dp, d, j));
        }

        dp[i] = result;
        return result;
    }

    public int maxJumps(int[] arr, int d) {
        int result = 0;
        int[] dp = new int[arr.length];

        for (int i = 0;i < arr.length;++ i) {
            result = Math.max(result, dfs(arr, dp, d, i));
        }

        return result;
    }
}
