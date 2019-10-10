package Recursion;

import java.util.HashSet;

import org.junit.Test;

/**
 * @author he.wu Write an algorithm to determine if a number is "happy".
 * 
 *         A happy number is a number defined by the following process: Starting
 *         with any positive integer, replace the number by the sum of the
 *         squares of its digits, and repeat the process until the number equals
 *         1 (where it will stay), or it loops endlessly in a cycle which does
 *         not include 1. Those numbers for which this process ends in 1 are
 *         happy numbers.
 * 
 *         Example:
 * 
 *         Input: 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82
 *         = 100 12 + 02 + 02 = 1
 */
public class HappyNumber202 {

	public int breakdown(int n) {
		int m = 0;
		while (n != 0) {
			m += (n % 10) * (n % 10);
			n /= 10;
		}
		return m;
	}

	public boolean isHappy2(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(n);
		while (true) {
			n = breakdown(n);
			if (set.contains(n))
				break;
			set.add(n);
		}
		return n == 1;
	}

	public boolean isHappy(int n) {
		int sum = 0;
		while (n > 0) {
			sum += Math.pow((n % 10), 2);
			n = n / 10;
		}
		if (sum >= 10)
			return isHappy(sum);
		else if (sum == 1 || sum == 7)
			return true;
		else
			return false;
	}

	@Test
	public void test() {
		int n = 19;
		System.out.println(isHappy2(2));
	}
}
