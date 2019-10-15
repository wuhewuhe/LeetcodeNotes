package Array;

import java.util.HashMap;
import java.util.Map;

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
	public String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";

		Map<Character, Integer> dictT = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			dictT.put(c, dictT.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
		int left = 0, right = 0, count = 0;
		while (right < s.length()) {

		}
	}
}
