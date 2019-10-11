package Math;

import org.junit.Test;

/**
 * @author he.wu 1201. Ugly Number III Medium
 * 
 *         82
 * 
 *         111
 * 
 *         Favorite
 * 
 *         Share Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive integers which are divisible by a or b or
 *         c.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: n = 3, a = 2, b = 3, c = 5 Output: 4 Explanation: The ugly
 *         numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4. Example 2:
 * 
 *         Input: n = 4, a = 2, b = 3, c = 4 Output: 6 Explanation: The ugly
 *         numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6. Example 3:
 * 
 *         Input: n = 5, a = 2, b = 11, c = 13 Output: 10 Explanation: The ugly
 *         numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10. Example 4:
 * 
 *         Input: n = 1000000000, a = 2, b = 217983653, c = 336916467 Output:
 *         1999999984
 */
public class UglyNumberIII1201 {
	// lcm leatest common multiple 最小公倍数 gcd greatest common divisor 最大公约数

	// find gcd use recursion
	public int GCD(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a == b)
			return a;
		return a > b ? GCD(a - b, b) : GCD(a, b - a);
	}

	public int gcd(int a, int b) {
		if (a == b)
			return a;
		if (a < b) {
			int tem = a;
			a = b;
			b = tem;
		}
		return a % b == 0 ? b : gcd(a, a % b);
	}

	public int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	private int count(int a, int b, int c, int num) {
		return ((num / a) + (num / b) + (num / c) - (num / lcm(a, b)) - (num / lcm(b, c)) - (num / lcm(a, c))
				+ (num / lcm(a, lcm(b, c))));
	}

	// binary search
	public int nthUglyNumber(int n, int a, int b, int c) {
		int low = 1, high = 10, mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (count(a, b, c, mid) < n)
				low = mid + 1;
			else
				high = mid;
		}
		return high;
	}

	@Test
	public void test() {
		System.out.println(Integer.MAX_VALUE > Math.pow(10, 9) ? true : false);
		System.out.println(nthUglyNumber(4, 2, 3, 4));
	}
}
