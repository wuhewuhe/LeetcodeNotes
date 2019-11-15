package Math;

import org.junit.Test;

/**
 * @author he.wu Given a non-negative integer num, repeatedly add all its digits
 *         until the result has only one digit.
 * 
 *         Example:
 * 
 *         Input: 38 Output: 2 Explanation: The process is like: 3 + 8 = 11, 1 +
 *         1 = 2. Since 2 has only one digit, return it. Follow up: Could you do
 *         it without any loop/recursion in O(1) runtime?
 */
public class AddDigits258 {
	public int addDigits(int num) {
		 return 1 + (num - 1) % 9;
	}

	@Test
	public void test() {
		int i = 38;
		System.out.println(addDigits(i));
	}
}
