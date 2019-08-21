package DistantBarcodes;

import java.util.*;

/**
 * In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

 Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.



 Example 1:

 Input: [1,1,1,2,2,2]
 Output: [2,1,2,1,2,1]
 Example 2:

 Input: [1,1,1,1,2,2,3,3]
 Output: [1,3,1,3,2,1,2,1]
 */
public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        int[] dp = new int[10001];
        for (int barcode : barcodes) {
            dp[barcode] ++;
        }

        for (int i = 1;i <= 10000;++ i) {
            if (dp[i] > 0) {
                pq.offer(new int[] {i, dp[i]});
            }
        }

        int idx = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            for (int j = 0;j < top[1];++ j) {
                if (idx >= barcodes.length) {
                    idx = 1;
                }

                barcodes[idx] = top[0];
                idx = idx + 2;
            }
        }

        return barcodes;
    }
}
