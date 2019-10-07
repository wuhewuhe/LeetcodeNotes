package Math;

import org.junit.Test;

/**
 * @author he.wu Implement int sqrt(int x).
 * 
 *         Compute and return the square root of x, where x is guaranteed to be
 *         a non-negative integer.
 * 
 *         Since the return type is an integer, the decimal digits are truncated
 *         and only the integer part of the result is returned.
 * 
 *         Example 1:
 * 
 *         Input: 4 Output: 2 Example 2:
 * 
 *         Input: 8 Output: 2 Explanation: The square root of 8 is 2.82842...,
 *         and since the decimal part is truncated, 2 is returned.
 */
public class SqrtX69 {
	public int mySqrt(int x) {
		if (x == 1)
			return 1;
		return (int) Math.sqrt(x);
	}

	public int mySqrt2(int x) {
		if (x == 0 || x == 1)
			return x;
		int left = 1, right = x / 2;
		while (left <= right ) {
			int mid = left + (right - left) / 2;
			if (x / mid == mid)
				return mid;
			else if (x / mid > mid)
				left = mid + 1;
			else
				right = mid-1;
		}
		return right;
	}

	@Test
	public void test() {
		System.out.println(mySqrt2(6));
	}
}
