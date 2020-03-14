package com;

/*Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell 
 * one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 */
public class BestTimeToBuyAndSellStocks {
	/* We keep finding min in array and keep updating it
	 * We change max value when the max value we have is less 
	 * than the (current price value -min). We return the max value
	 * for profit.
	 */
	public int maxProfit(int[] prices) {
		//Base case
		if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		//Setting min as max int value and max as zero
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; ++i) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}
}
