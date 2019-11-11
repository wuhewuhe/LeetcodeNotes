package BitManipulation;

import org.junit.Test;

/**
 * @author mac Given an integer, write a function to determine if it is a power
 *         of two.
 * 
 *         Example 1:
 * 
 *         Input: 1 Output: true Explanation: 20 = 1 Example 2:
 * 
 *         Input: 16 Output: true Explanation: 24 = 16 Example 3:
 * 
 *         Input: 218 Output: false
 * 
 *         ^ operator, equal 0, else 1
 */
public class PowerOfTwo231 {
	public boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;
		while (n % 2 == 0)
			n /= 2;
		return n == 1;
	}

	public boolean isPowerOfTwo2(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}

	@Test
	public void test() {
		System.out.println(isPowerOfTwo(16));
	}
}
