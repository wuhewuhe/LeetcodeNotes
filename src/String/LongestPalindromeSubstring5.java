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
		int max = 0;
		String str = new String();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (j - i + 1 > max && validPalin(s, i, j)) {
					max = s.substring(i, j + 1).length();
					str = s.substring(i, j + 1);
				}
			}
		}
		return str;
	}

	private boolean validPalin(String s, int start, int end) {
		s = s.substring(start, end + 1);
		for (int i = start; i < (end + 1 - start) / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

	public String longestPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;
		int len = 0;
		String longestPalindrome = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (j + 1 - i > len) {
					if (s.substring(i, j + 1).equals(new StringBuilder(s.substring(i, j + 1)).reverse().toString())) {
						len = s.substring(i, j + 1).length();
						longestPalindrome = s.substring(i, j + 1);
					}
				}
			}
		}
		return longestPalindrome;
	}

	// two pointer
	public String longestPalindrome3(String s) {
		if (s == null || s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;
		String longest = new String();
		for (int i = 0; i < s.length(); i++) {
			String s1 = palinLength(s, i, i);
			String s2 = palinLength(s, i, i + 1);
			String longer = s1.length() > s2.length() ? s1 : s2;
			longest = longer.length() > longest.length() ? longer : longest;
		}
		return longest;
	}

	private String palinLength(String s, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void test() {
		String s = "";
		System.out.println(longestPalindrome(s));
	}
}
