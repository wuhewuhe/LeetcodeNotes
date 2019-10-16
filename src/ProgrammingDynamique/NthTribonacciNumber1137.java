package ProgrammingDynamique;

import org.junit.Test;

/**
 * @author he.wu The Tribonacci sequence Tn is defined as follows:
 * 
 *         T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 *         Given n, return the value of Tn.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: n = 4 Output: 4 Explanation: T_3 = 0 + 1 + 1 = 2 T_4 = 1 + 1 +
 *         2 = 4 Example 2:
 * 
 *         Input: n = 25 Output: 1389537
 * 
 * 
 *         Constraints:
 * 
 *         0 <= n <= 37 The answer is guaranteed to fit within a 32-bit integer,
 *         ie. answer <= 2^31 - 1.
 */
public class NthTribonacciNumber1137 {
	public int tribonacci(int n) {
		if (n < 0)
			return 0;
		if (n <= 1)
			return n;
		if (n == 2)
			return 1;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	// revo roller array
	public int tribonacci2(int n) {
		if (n < 0)
			return 0;
		if (n <= 1)
			return n;
		if (n == 2)
			return 1;
		int first = 0, second = 1, third = 1;
		for (int i = 3; i <= n; i++) {
			int temp = first + second + third;
			first = second;
			second = third;
			third = temp;
		}
		return third;
	}

	@Test
	public void test() {
		System.out.println(tribonacci2(25));
	}
}
