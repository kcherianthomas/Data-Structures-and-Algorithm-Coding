package com;

public class BestTimetoBuyandSellStockwithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int length = prices.length;
		int[] buy = new int[length];
		int[] sell = new int[length];
		buy[0] = -prices[0];
		sell[0] = 0;
		for (int i = 1; i < length; ++i) {
			buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
		}
		return sell[length - 1];
	}
	// can be simplified as
	/*
	 * int buy = -prices[0]; int sell = 0; for (int i = 1; i < prices.length; ++i) {
	 * sell = Math.max(sell, buy + prices[i] - fee); buy = Math.max(buy, sell-
	 * prices[i]);
	 * 
	 * } return sell;
	 */
}
