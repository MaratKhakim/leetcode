package greedy;

/**
 * Date 09.04.2020.
 *
 * 122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int profit = 0;
        int buy = prices[0];

        for (int price : prices) {
            if (price > buy) {
                profit += price - buy;
            }

            buy = price;
        }

        return profit;
    }
}
