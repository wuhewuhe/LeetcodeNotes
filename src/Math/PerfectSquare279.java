package Math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a positive integer n, find the least number of perfect
 *         square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 *         Example 1:
 * 
 *         Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 *         Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 */
public class PerfectSquare279 {
	public boolean isSqrt(int n) {
		if (n <= 0)
			return false;
		if (n == 1)
			return true;
		return (double) Math.sqrt(n) - (int) Math.sqrt(n) == 0;
	}

	public int numSquares(int n) {

		if (n < 4)// 1 plus n time
			return n;

		int[] res = new int[n + 1];

		// initialize the array values for all perfect squares
		for (int i = 1; i * i <= n; i++)
			res[i * i] = 1;

		return recNumSq(n, res);
	}

	private int recNumSq(int n, int[] cache) {

		if (cache[n] != 0)
			return cache[n];

		int min = n;
		// for each i*i less than n, add count of n/(i*i) and recurse over remainder
		for (int i = (int) Math.sqrt(n); i > 1 && min > 2; i--) {
			min = Math.min(min, n / (i * i) + recNumSq(n - i * i * (n / (i * i)), cache));
		}

		cache[n] = min;
		return min;
	}

	@Test
	public void test() {
		System.out.println(numSquares(12));
	}
}
