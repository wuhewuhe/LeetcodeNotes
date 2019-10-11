package String;

import org.junit.Test;

/**
 * @author he.wu The count-and-say sequence is the sequence of integers with the
 *         first five terms as following:
 * 
 *         1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11
 *         is read off as "two 1s" or 21. 21 is read off as "one 2, then one 1"
 *         or 1211.
 * 
 *         Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the
 *         count-and-say sequence.
 * 
 *         Note: Each term of the sequence of integers will be represented as a
 *         string.
 */
public class CountAndSay38 {
	public String countAndSay(int n) {
		String s = "1"; // base
		for (int i = 1; i < n; i++) { // build the numbers from 1 to n
			s = nextNumber(s);
		}
		return s; // return result
	}

	private static String nextNumber(String s) {
		StringBuilder result = new StringBuilder(); 
		for (int i = 0; i < s.length(); i++) { 
			int count = 1; 
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) { 
				i++; 
				count++; // increment how many times we've seen that #
			}
			result.append(count).append(s.charAt(i)); // and append the count and then the #
		}
		return result.toString(); // and finally return
	}

	@Test
	public void test() {
		System.out.println(countAndSay(4));
	}
}
