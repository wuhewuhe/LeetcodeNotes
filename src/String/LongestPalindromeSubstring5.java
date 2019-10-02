package String;

import org.junit.Test;

/**
 * @author he.wu Given a string s, find the longest palindromic substring in s.
 *         You may assume that the maximum length of s is 1000.
 * 
 *         Example 1:
 * 
 *         Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 *         Example 2:
 * 
 *         Input: "cbbd" Output: "bb"
 */
public class LongestPalindromeSubstring5 {

	// brutal force
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			throw new IllegalArgumentException("No solution");
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (validPalin(s, i, j))
					return s.substring(i, j);
			}
		}
		throw new IllegalArgumentException("No solution");
	}

	private boolean validPalin(String s, int start, int end) {
		// TODO Auto-generated method stub
		for (int i = start; i <= (end - start) / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
		}
		return true;
	}
	
	@Test
	public void test() {
		System.out.println(longestPalindrome("babad"));
	}
}
