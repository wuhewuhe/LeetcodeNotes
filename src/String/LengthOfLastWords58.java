package String;

import org.junit.Test;

/**
 * @author he.wu Given a string s consists of upper/lower-case alphabets and
 *         empty space characters ' ', return the length of last word in the
 *         string.
 * 
 *         If the last word does not exist, return 0.
 * 
 *         Note: A word is defined as a character sequence consists of non-space
 *         characters only.
 * 
 *         Example:
 * 
 *         Input: "Hello World" Output: 5
 */
public class LengthOfLastWords58 {
	public int lengthOfLastWord(String s) {
		String[] strs = s.split(" ");
		return strs.length == 0 ? 0 : strs[strs.length - 1].length();
	}

	@Test
	public void test() {
		String s = " ";
		System.out.println(lengthOfLastWord(s));
	}
}
