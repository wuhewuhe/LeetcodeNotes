package ProgrammingDynamique;


import org.junit.Test;

/**
 * @author he.wu Your are given an array of integers prices, for which the i-th
 *         element is the price of a given stock on day i; and a non-negative
 *         integer fee representing a transaction fee.
 * 
 *         You may complete as many transactions as you like, but you need to
 *         pay the transaction fee for each transaction. You may not buy more
 *         than 1 share of a stock at a time (ie. you must sell the stock share
 *         before you buy again.)
 * 
 *         Return the maximum profit you can make.
 * 
 *         Example 1: Input: prices = [1, 3, 2, 8, 4, 9], fee = 2 Output: 8
 *         Explanation: The maximum profit can be achieved by: Buying at
 *         prices[0] = 1 Selling at prices[3] = 8 Buying at prices[4] = 4
 *         Selling at prices[5] = 9 The total profit is ((8 - 1) - 2) + ((9 - 4)
 *         - 2) = 8. Note:
 * 
 *         0 < prices.length <= 50000. 0 < prices[i] < 50000. 0 <= fee < 50000.
 */
public class BestTimeToBuySellStockTractionFee714 {

	// dp time o(n) space o(n)
	// sold: no stock in my hand maximum revenue: two possible(keep state or sell
	// stock today)
	// hold: have stock in my hand maximum revenue: two possible(keep state or buy
	// stock today)
	public int MaxProfit(int[] prices, int fee) {
		if (prices == null || prices.length == 0)
			return 0;
		if (prices.length == 1)
			return 0;
		if (prices.length == 2)
			return prices[1] - prices[0] - fee > 0 ? prices[1] - prices[0] - fee : 0;
		int[] hold = new int[prices.length], sold = new int[prices.length];
		hold[0] = -prices[0];
		sold[0] = 0;
		for (int i = 1; i < sold.length; i++) {
			sold[i] = Math.max(sold[i - 1], prices[i] + hold[i - 1] - fee);
			hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
		}
		return sold[prices.length - 1];
	}

	// alter greedy algorithm
	// time o(n) space o(1)
	public int MaxProfit2(int[] prices, int fee) {
		if (prices == null || prices.length == 0)
			return 0;
		if (prices.length == 1)
			return 0;
		if (prices.length == 2)
			return prices[1] - prices[0] - fee > 0 ? prices[1] - prices[0] - fee : 0;
		int profit = 0, min = prices[0], max = prices[0], sum = 0;
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i]);
			profit = Math.max(prices[i] - fee - min, profit);
			if (max - prices[i] - fee > 0) {
				sum += profit;
				profit = 0;
				min = prices[i];
				max = prices[i];
			}
		}
		return sum + profit;
	}

	public int MaxProfit3(int[] prices, int fee) {
		int sold = 0, hold = -prices[0];
		for (int i = 0; i < prices.length; i++) {
			sold = Math.max(sold, hold+prices[i]-fee);
			hold = Math.max(hold, sold - prices[i]);
		}
		return sold;
	}

	@Test
	public void test() {
		int[] prices = { 1, 3, 2, 8, 4, 9 };
		System.out.println(MaxProfit(prices, 2));
	}
}
