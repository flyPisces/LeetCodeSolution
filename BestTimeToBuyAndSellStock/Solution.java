package BestTimeToBuyAndSellStock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

    Subscribe to see which companies asked this question
 *
 * Created by aoshen on 4/5/16.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        if (prices == null || prices.length == 0 || prices.length == 1) {
            return max;
        }

        int minEle = Integer.MAX_VALUE;

        for (int i = 0;i != prices.length;++ i) {
            max = Math.max(max, prices[i] - minEle);
            minEle = Math.min(minEle, prices[i]);
        }

        return max;
    }
}
