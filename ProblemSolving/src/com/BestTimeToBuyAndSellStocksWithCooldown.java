package com;

public class BestTimeToBuyAndSellStocksWithCooldown {
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length <= 1) {
			return 0;
		}
		int[] buy = new int[length];
		int[] sell = new int[length];
		// buy[0] is profit when we have stock at 0. Therefore we need to buy stock at
		// 0. which gives profit = - prices[0]
		buy[0] = -prices[0];
		// sell[0] is when we have no stock at time 0. therefore it is 0
		sell[0] = 0;
		// buy[1] is when we have a stock at time =1. The profit should be maximum.
		// Therefore we take min value for prices at 0 and 1 and since we buy that stock
		// it will be negative
		buy[1] = -Math.min(prices[1], prices[0]);
		// sell at one means we have no stock at time 1. therefore we can either sell
		// stock we bought at time 0 or we can have no stock at all which ever is
		// maximum
		sell[1] = Math.max(sell[0], buy[0] + prices[1]);
		for (int i = 2; i < length; ++i) {
			// stock at i means we can have some profit as stock at i-1 or we can sell at
			// i-2 and buy at i
			buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
			// no stock at i means we can have no stock at i-1, or sell stock at i
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}
		return sell[length - 1];
	}
}
