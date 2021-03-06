package ProgrammingDynamique;

import org.junit.Test;

/**
 * @author he.wu Say you have an array for which the ith element is the price of
 *         a given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (i.e., buy one and sell one share of
 *         the stock multiple times).
 * 
 *         Note: You may not engage in multiple transactions at the same time
 *         (i.e., you must sell the stock before you buy again).
 * 
 *         Example 1:
 * 
 *         Input: [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1)
 *         and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4
 *         (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Example
 *         2:
 * 
 *         Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1)
 *         and sell on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot
 *         buy on day 1, buy on day 2 and sell them later, as you are engaging
 *         multiple transactions at the same time. You must sell before buying
 *         again. Example 3:
 * 
 *         Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no
 *         transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuySellStock122 {

	@Test
	public void test() {
		int[] nums = { 7, 1, 5, 3, 6, 4 };
		System.out.println(MaxProfit3(nums));
	}

	// brute force deep recursive, find all possibility and compare the max
	// time o(n^2) space o(n)
	public int MaxProfit(int[] prices) {
		return Calculate(prices, 0);
	}

	public int Calculate(int prices[], int s) {
		if (s >= prices.length)
			return 0;
		int max = 0;
		for (int start = s; start < prices.length; start++) {
			int maxprofit = 0;
			for (int i = start + 1; i < prices.length; i++) {
				if (prices[start] < prices[i]) {
					int profit = Calculate(prices, i + 1) + prices[i] - prices[start];
					if (profit > maxprofit)
						maxprofit = profit;
				}
			}
			if (maxprofit > max)
				max = maxprofit;
		}
		return max;
	}

	// peak valley approach time o(n) space o(1)
	// one technique that we can find from graph that c always less or equal to A +B
	public int MaxProfit2(int[] prices) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			while (i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}

	// single one pass
	//transaction more than the last method, greedy algorithm
	public int MaxProfit3(int[] prices) {
		int maxprofit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				maxprofit += prices[i] - prices[i - 1];
		}
		return maxprofit;
	}

}
