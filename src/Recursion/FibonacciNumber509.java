package Recursion;

import org.junit.Test;

/**
 * @author he.wu The Fibonacci numbers, commonly denoted F(n) form a sequence,
 *         called the Fibonacci sequence, such that each number is the sum of
 *         the two preceding ones, starting from 0 and 1. That is,
 * 
 *         F(0) = 0, F(1) = 1 F(N) = F(N - 1) + F(N - 2), for N > 1. Given N,
 *         calculate F(N).
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: 2 Output: 1 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *         Example 2:
 * 
 *         Input: 3 Output: 2 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *         Example 3:
 * 
 *         Input: 4 Output: 3 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * 
 *         Note:
 * 
 *         0 ≤ N ≤ 30.
 */
public class FibonacciNumber509 {
	// recursion 2^n
	public int fib(int N) {
		if (N <= 1) {
			return N;
		}
		return fib(N - 1) + fib(N - 2);
	}

	// iterative
	public int fib2(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;
		int first = 0, second = 1;
		for (int i = 2; i <= N; i++) {
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}

	// dp bottom up
	public int fib3(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[N];
	}

	// dp up down
	public int fib4(int n) {
		if (n <= 1)
			return n;
		Integer[] cache = new Integer[31];// Integer is an objet
		cache[0] = 0;
		cache[1] = 1;
		return memory(cache, n);
	}

	private int memory(Integer[] cache, int n) {
		if (cache[n] != null) {
			return cache[n];
		}
		cache[n] = memory(cache, n - 1) + memory(cache, n - 2);
		return memory(cache, n);
	}

	@Test
	public void test() {
		System.out.println(fib4(5));
	}
}
