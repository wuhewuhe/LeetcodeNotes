package Array;

import org.junit.Test;

/**
 * @author he.wu Say you have an array for which the ith element is the price of
 *         a given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete at
 *         most two transactions.
 * 
 *         Note: You may not engage in multiple transactions at the same time
 *         (i.e., you must sell the stock before you buy again).
 * 
 *         Example 1:
 * 
 *         Input: [3,3,5,0,0,3,1,4] Output: 6 Explanation: Buy on day 4 (price =
 *         0) and sell on day 6 (price = 3), profit = 3-0 = 3. Then buy on day 7
 *         (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3. Example
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
public class BestTimeToBuySellStockIII123 {

	// use an array, first loop can get the maximum profit by one transaction in
	// i-th day
	// second loop, inverse the array and get the second max profit
	// time o(n) space o(n)
	public int MaxProfit(int[] prices) {
		if (prices.length <= 1 || prices == null)
			return 0;
		if (prices.length == 2)
			return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
		int[] first = new int[prices.length];
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			first[i] = Math.max(first[i - 1], prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		int max = prices[prices.length - 1];
		int second = 0;
		for (int i = prices.length - 2; i >= 0; i--) {

			second = Math.max(second, max - prices[i] + first[i]);
			max = Math.max(prices[i], max);
		}
		return second;
	}

	// 4 variable
	public int MaxProfit2(int[] prices) {
		if (prices.length <= 1 || prices == null)
			return 0;
		if (prices.length == 2)
			return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
		int firstbuy, firstsell, secondbuy, secondsell;
		firstbuy = prices[0];
		firstsell = 0;
		secondbuy = Integer.MIN_VALUE;
		secondsell = 0;
		for (int i = 1; i < prices.length; i++) {
			if (firstbuy > prices[i])
				firstbuy = prices[i];
			if (prices[i] - firstbuy > firstsell)
				firstsell = prices[i] - firstbuy;
			if (secondbuy < firstsell - prices[i])
				secondbuy = firstsell - prices[i];
			if (prices[i] + secondbuy > secondsell)
				secondsell = prices[i] + secondbuy;
		}
		return secondsell;
	}

	public int MaxProfit3(int[] prices) {
		if (prices.length <= 1 || prices == null)
			return 0;
		if (prices.length == 2)
			return prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
		int firstbuy, firstsell, secondbuy, secondsell;
		firstbuy = -prices[0];
		firstsell = 0;
		secondbuy = Integer.MIN_VALUE;
		secondsell = 0;
		for (int i : prices) {
			firstbuy = Math.max(firstbuy, -i);
			firstsell = Math.max(i + firstbuy, firstsell);
			secondbuy = Math.max(secondbuy, firstsell - i);
			secondsell = Math.max(i + secondbuy, secondsell);
		}
		return secondsell;
	}


	@Test
	public void test() {
		int[] prices = { 2, 1, 2, 0, 1 };
		System.out.println(MaxProfit3(prices));
	}
}
