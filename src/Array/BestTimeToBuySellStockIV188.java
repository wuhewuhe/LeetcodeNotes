package Array;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

/**
 * @author he.wu Say you have an array for which the i-th element is the price
 *         of a given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete at
 *         most k transactions.
 * 
 *         Note: You may not engage in multiple transactions at the same time
 *         (ie, you must sell the stock before you buy again).
 * 
 *         Example 1:
 * 
 *         Input: [2,4,1], k = 2 Output: 2 Explanation: Buy on day 1 (price = 2)
 *         and sell on day 2 (price = 4), profit = 4-2 = 2. Example 2:
 * 
 *         Input: [3,2,6,5,0,3], k = 2 Output: 7 Explanation: Buy on day 2
 *         (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy
 *         on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimeToBuySellStockIV188 {

	// three dimension array, first is date, second is transaction, third is whether
	// has stock or not space[n^3]
	public int MaxProfit(int[] prices, int k) {
		if (prices.length <= 1 || prices == null)
			return 0;
		if (prices.length / 2 <= k)
			return sub(prices);
		// first dimension is date, second dimension is time of transaction, third
		// dimension is whether has stock or not
		// 0 is no stock, 1 is has stock
		int[][][] dp = new int[prices.length][k + 1][2];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k + 1; i++) {
			dp[0][i][0] = 0;
			dp[0][i][1] = -prices[0];
		}
		for (int i = 1; i < prices.length; i++) {
			for (int j = 0; j < k + 1; j++) {
				if (j == 0)
					dp[i][j][0] = 0;
				else
					dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
			}
		}
		for (int i = 0; i < k + 1; i++) {
			max = Math.max(max, dp[prices.length - 1][i][0]);
		}
		return max;
	}

	public int sub(int[] prices) {
		// TODO Auto-generated method stub
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			profit += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
		}
		return profit;
	}

	//space n^2
	public int MaxProfit2(int[] prices, int k) {
		if (prices.length < 2)
			return 0;
		if (prices.length / 2 <= k) {
			int profit = 0;
			for (int i = 1; i < prices.length; i++) {
				profit += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
			}
			return profit;
		} else {
			int[][] hold = new int[prices.length][k + 1], sell = new int[prices.length][k + 1];
			hold[0][0] = -prices[0];
			for (int i = 1; i < prices.length; i++)
				hold[i][0] = Math.max(hold[i - 1][0], -prices[i]);
			for (int i = 1; i <= k; i++)
				hold[0][i] = -prices[0];
			for (int i = 1; i < prices.length; i++) {
				for (int j = 1; j < k + 1; j++) {
					hold[i][j] = Math.max(hold[i - 1][j], sell[i - 1][j] - prices[i]);
					sell[i][j] = Math.max(sell[i - 1][j], hold[i - 1][j - 1] + prices[i]);
				}
			}
			return sell[prices.length - 1][k];
		}

	}

	//time nk space n
	public int MaxProfit3(int[] prices, int k) {
		if (prices == null || prices.length <= 1)
			return 0;
		int len = prices.length;
		if (k > len / 2) { // simple case
			int res = 0;
			for (int i = 1; i < len; ++i) {
				if (prices[i] > prices[i - 1])
					res += prices[i] - prices[i - 1];
			}
			return res;
		}
		int[] hold = new int[k + 1];
		int[] sold = new int[k + 1];
		Arrays.fill(hold, Integer.MIN_VALUE);
		for (int price : prices) {
			for (int j = 1; j <= k; j++) {
				hold[j] = Math.max(hold[j], sold[j - 1] - price); // hold->hold, sold->hold
				sold[j] = Math.max(sold[j], hold[j] + price); // sold->sold, hold->sold
			}
		}
		return sold[k];
	}

	@Test
	public void test() {
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		System.out.println(MaxProfit3(prices, 2));
	}

}
