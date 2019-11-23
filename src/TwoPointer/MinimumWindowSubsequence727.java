package TwoPointer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac Given strings S and T, find the minimum (contiguous) substring W
 *         of S, so that T is a subsequence of W.
 * 
 *         If there is no such window in S that covers all characters in T,
 *         return the empty string "". If there are multiple such minimum-length
 *         windows, return the one with the left-most starting index.
 * 
 *         Example 1:
 * 
 *         Input: S = "abcdebdde", T = "bde" Output: "bcde" Explanation: "bcde"
 *         is the answer because it occurs before "bdde" which has the same
 *         length. "deb" is not a smaller window because the elements of T in
 *         the window must occur in order.
 * 
 * 
 *         Note:
 * 
 *         All the strings in the input will only contain lowercase letters. The
 *         length of S will be in the range [1, 20000]. The length of T will be
 *         in the range [1, 100].
 */

public class MinimumWindowSubsequence727 {

	public String minWindow(String s, String t) {
		if (s == null || t == null)
			return "";
		int[] hash = new int[26];
		char[] chars = s.toCharArray();
		for (char c : t.toCharArray()) {
			hash[c - 'a']--;
		}
		int count = 0, left = 0, res = s.length();
		int start = 0, end = 0;
		for (int i = 0; i < chars.length; i++) {
			hash[chars[i] - 'a']++;
			if (hash[chars[i] - 'a'] <= 0)
				count++;
			while (count == t.length()) {
				if (i - left + 1 < res) {
					res = i - left + 1;
					start = left;
					end = i + 1;
				}
				char tem = chars[left];
				hash[tem - 'a']--;
				if (hash[tem - 'a'] < 0)
					count--;
				left++;
			}
		}
		return s.substring(start, end);
	}

	// revolution
	public String minWindowInorder(String s, String t) {
		if (s == null || t == null)
			return "";
		int[] hash = new int[26];
		char[] chars = s.toCharArray();
		for (char c : t.toCharArray()) {
			hash[c - 'a']--;
		}
		int count = 0, left = 0, res = s.length();
		int start = 0, end = 0;
		for (int i = 0; i < chars.length; i++) {
			hash[chars[i] - 'a']++;
			if (hash[chars[i] - 'a'] <= 0)
				count++;
			while (count == t.length()) {
				if (i - left + 1 < res && check(s.substring(left, i + 1), t)) {
					res = i - left + 1;
					start = left;
					end = i + 1;
				}
				char tem = chars[left];
				hash[tem - 'a']--;
				if (hash[tem - 'a'] < 0)
					count--;
				left++;
			}
		}
		return s.substring(start, end);
	}

	

	private boolean check(String substring, String t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Test
	public void test() {
		String S = "abcdebdde", T = "bde";
		System.out.println(minWindowInorder(S, T));
	}
}
