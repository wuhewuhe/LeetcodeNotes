package Array;

import org.junit.Test;

/**
 * @author he.wu Say you have an array for which the ith element is the price of
 *         a given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (ie, buy one and sell one share of the
 *         stock multiple times) with the following restrictions:
 * 
 *         You may not engage in multiple transactions at the same time (ie, you
 *         must sell the stock before you buy again). After you sell your stock,
 *         you cannot buy stock on next day. (ie, cooldown 1 day)
 * 
 *         Example:
 * 
 *         Input: [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell,
 *         cooldown, buy, sell]
 */
public class BestTimeToBuySellStockCooldown309 {

	// brute force o(n^3)

	// rest,sell,buy
	public int MaxProfit(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1)
			return 0;
		if (prices.length == 2)
			return prices[1] > prices[0] ? prices[1] - prices[0] : 0;
		int sell = 0, rest = 0, buy = Integer.MIN_VALUE;
		for (int i : prices) {
			int prev_buy = buy;
	        buy = Math.max(sell - i, prev_buy);
	        rest = sell;
	        sell = Math.max(prev_buy + i, rest);
		}
		return Math.max(rest, sell);
	}

	@Test
	public void test() {
		int[] prices = { 1, 2, 3, 0, 2 };
		System.out.println(MaxProfit(prices));
	}
}
