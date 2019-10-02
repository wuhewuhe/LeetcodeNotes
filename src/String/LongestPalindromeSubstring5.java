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

	// manachar algo
	

	private int max = 0;
	private String sub = "";

	public String longestPalindrome4(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++)// assume index not out off range
		{
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return sub;
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			if (k - j + 1 > max) {
				max = k-j+1;
				sub = s.substring(j,k+1);
			}
			j--;
			k++;
		}

	}

	@Test
	public void test() {
		String s = "aca";
		System.out.println(longestPalindrome4(s));
	}
}
