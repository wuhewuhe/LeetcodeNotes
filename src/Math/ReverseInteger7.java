package Math;

import org.junit.Test;

/**
 * @author he.wu Given a 32-bit signed integer, reverse digits of an integer.
 * 
 *         Example 1:
 * 
 *         Input: 123 Output: 321 Example 2:
 * 
 *         Input: -123 Output: -321 Example 3:
 * 
 *         Input: 120 Output: 21 Note: Assume we are dealing with an environment
 *         which could only store integers within the 32-bit signed integer
 *         range: [−231, 231 − 1]. For the purpose of this problem, assume that
 *         your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger7 {
	/*
	 * number %10 = last numreo, number / 0 * count = delete first numero Integer
	 * max value is 2 ^31 - 1 = 2147483647 min -2147483648
	 */
	public int reverse(int x) {
		if (x == 0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
			return 0;
		int num = 0;
		while (x != 0) {
			int last = x % 10;
			x /= 10;
			num = last + num * 10;
		}
		return num;
	}

	public int reverse2(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public int reverse3(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
		}
		return (int) res == res ? (int) res : 0;
	}

	@Test
	public void test() {
		int x = -123;
//		StringBuilder s = new StringBuilder(Integer.toString(x));
		System.out.println((long) Math.pow(2, 31) + " " + (Integer.MAX_VALUE));
		System.out.println(reverse(x));
	}
}
