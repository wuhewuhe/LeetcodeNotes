package Array;

import java.util.Arrays;

/**
 * @author mac Given a string S and a string T, find the minimum window in S
 *         which will contain all the characters in T in complexity O(n).
 * 
 *         Example:
 * 
 *         Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC" Note:
 * 
 *         If there is no such window in S that covers all characters in T,
 *         return the empty string "". If there is such window, you are
 *         guaranteed that there will always be only one unique minimum window
 *         in S.
 */
public class SlidingWindowSubstring76 {
	public static String minWindow(String s, String t) {

		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c] += 1;
		}
		int begin = 0;
		int len = Integer.MAX_VALUE;
		int count = t.length();
		for (int left = 0, right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			map[c]--;
			if (map[c] >= 0)
				count--;
			while (count == 0) {
				char lc = s.charAt(left);
				map[lc]++;
				if (map[lc] > 0) {
					if (right - left + 1 < len) {
						begin = left;
						len = right - left + 1;
					}
					count++;
				}
				left++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(begin, begin + len);

	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC", T = "ABC";
		System.out.println(minWindow(S, T));
	}
}
