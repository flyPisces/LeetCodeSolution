package BestTimetoBuyandSellStockwithTransactionFee;

/**
 * Your are given an array of integers prices,
 * for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

 You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

 Return the maximum profit you can make.

 Example 1:
 Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 Output: 8
 Explanation: The maximum profit can be achieved by:
 Buying at prices[0] = 1
 Selling at prices[3] = 8
 Buying at prices[4] = 4
 Selling at prices[5] = 9
 The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] skip = new int[prices.length];

        buy[0] = -prices[0];
        hold[0] = -prices[0];

        for (int i = 1;i < prices.length;++ i) {
            buy[i] = Math.max(sell[i - 1], skip[i - 1]) - prices[i];
            hold[i] = Math.max(hold[i - 1], buy[i - 1]);
            skip[i] = Math.max(skip[i - 1], sell[i - 1]);
            sell[i] = Math.max(buy[i - 1], hold[i - 1]) + prices[i] - fee;
        }

        int max = Math.max(buy[prices.length - 1], sell[prices.length - 1]);
        max = Math.max(max, Math.max(hold[prices.length - 1], skip[prices.length - 1]));

        return Math.max(0, max);
    }
}
