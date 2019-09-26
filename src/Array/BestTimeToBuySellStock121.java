package Array;

import org.junit.Test;

/**
 * @author he.wu
 *
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         If you were only permitted to complete at most one transaction (i.e.,
 *         buy one and sell one share of the stock), design an algorithm to find
 *         the maximum profit.
 * 
 *         Note that you cannot sell a stock before you buy one.
 * 
 *         Example 1:
 * 
 *         Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
 *         and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as
 *         selling price needs to be larger than buying price. Example 2:
 * 
 *         Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no
 *         transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuySellStock121 {

	// selection sort, time o(n^2) space o(1)
	public int MaxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				max = Math.max(prices[j] - prices[i], max);
			}
		}
		return max;
	}

	//one pass time o(n) space o(1)
	//one pointer, find the miniprice and compare each time of difference prix to find the peak
	public int MaxProfit2(int[] prices) {
		int miniprice = Integer.MAX_VALUE, maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < miniprice)
				miniprice = prices[i];
			maxprofit = Math.max(prices[i] - miniprice, maxprofit);
		}
		return maxprofit;
	}

	@Test
	public void test() {
		int[] nums = { 7, 1, 5, 3, 6, 4 };
		System.out.println(MaxProfit2(nums));
	}
}
