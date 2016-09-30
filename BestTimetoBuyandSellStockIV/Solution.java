package BestTimetoBuyandSellStockIV;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 * Created by aoshen on 6/6/16.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length < 2) {
            return 0;
        }

        if (k >= prices.length) {
            return helper(prices);
        }

        int[][] local = new int[prices.length][k + 1];
        int[][] global = new int[prices.length][k + 1];

        for (int i = 1;i < prices.length;++ i) {
            int diff = prices[i] - prices[i- 1];

            for (int j = 1;j <= k;++ j) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, diff), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }

    private int helper(int[] prices) {
        int profit = 0;

        for (int i = 1;i < prices.length;++ i) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
