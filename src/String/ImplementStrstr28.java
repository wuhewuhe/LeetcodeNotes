package String;

import org.junit.Test;

/**
 * @author mac Implement strStr().
 * 
 *         Return the index of the first occurrence of needle in haystack, or -1
 *         if needle is not part of haystack.
 * 
 *         Example 1:
 * 
 *         Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 *         Input: haystack = "aaaaa", needle = "bba" Output: -1 Clarification:
 * 
 *         What should we return when needle is an empty string? This is a great
 *         question to ask during an interview.
 * 
 *         For the purpose of this problem, we will return 0 when needle is an
 *         empty string. This is consistent to C's strstr() and Java's
 *         indexOf().
 */
public class ImplementStrstr28 {
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	// realise index of manuel
	public int strStr2(String s, String t) {
		if (t.isEmpty())
			return 0; // edge case: "",""=>0 "a",""=>0
		for (int i = 0; i <= s.length() - t.length(); i++) {
			for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
				if (j == t.length() - 1)
					return i;
		}
		return -1;
	}

	public void prefixtable(char[] pattern, int[] prefix, int n) {
		prefix[0] = 0;
		int len = 0;
		int i = 1;
		while (i < n) {
			if (pattern[len] == pattern[i]) {
				len++;
				prefix[i] = len;
				i++;
			} else {
				if (len > 0)
					len = prefix[len - 1];
				else {
					prefix[i] = len;
					i++;
				}
			}
		}
	}

	public void move(int[] prefix, int n) {
		int i;
		for (i = n - 1; i > 0; i--) {
			prefix[i] = prefix[i - 1];
		}
		prefix[0] = -1;
	}

	public int kmp_search(char[] text, char[] pattern) {

		int n = pattern.length;
		int[] prefix = new int[pattern.length];
		prefixtable(pattern, prefix, n);
		move(prefix, n);

		// text[i] len(text) = m
		// pattern[j] len(pattern) = n
		int i = 0, m = text.length;
		int j = 0;
		while (i < m) {
			if (j == n - 1 && text[i] == pattern[j]) {
				// System.out.println("found" + (i-j));
				//j = prefix[j];
				return i-j;
			}
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = prefix[j];
				if (j == -1) {
					i++;
					j++;
				}
			}
		}
		return -1;
	}

	public int strStr3(String haystack, String needle) {
		if(needle.isEmpty()) return 0;
		return kmp_search(haystack.toCharArray(), needle.toCharArray());
	}

	@Test
	public void test() {
		System.out.println(strStr3("hello", "ll"));
	}
}
