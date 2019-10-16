package Recursion;

import org.junit.Test;

/**
 * @author he.wu You are climbing a stair case. It takes n steps to reach to the
 *         top.
 * 
 *         Each time you can either climb 1 or 2 steps. In how many distinct
 *         ways can you climb to the top?
 * 
 *         Note: Given n will be a positive integer.
 * 
 *         Example 1:
 * 
 *         Input: 2 Output: 2 Explanation: There are two ways to climb to the
 *         top. 1. 1 step + 1 step 2. 2 steps Example 2:
 * 
 *         Input: 3 Output: 3 Explanation: There are three ways to climb to the
 *         top. 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1
 *         step
 */
public class ClimbingStairs70 {
	// recursion tree time(2^n)
	public int climbStairs(int n) {
		return climb(0, n);
	}

	private int climb(int i, int n) {
		if (i > n)
			return 0;
		if (i == n)
			return 1;
		return climb(i + 1, n) + climb(i + 2, n);
	}

	// recursion with memorization
	public int climbStairs4(int n) {
		int memo[] = new int[n + 1];
		return climb_Stairs(0, n, memo);
	}

	private int climb_Stairs(int i, int n, int[] memo) {
		if (i > n) {
			return 0;
		}
		if (i == n)
			return 1;
		if (memo[i] > 0) {
			return memo[i];
		}
		memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
		return memo[i];
	}

	// programming dynamic
	public int climbStairs2(int n) {
		if (n == 1)
			return 1;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < dp.length; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n - 1];
	}

	// fibonaci number
	public int climbStairs3(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int first = 1, second = 2;
		for (int i = 2; i < n; i++) {
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}

	@Test
	public void test() {
		System.out.println(climbStairs4(5));
	}
}
