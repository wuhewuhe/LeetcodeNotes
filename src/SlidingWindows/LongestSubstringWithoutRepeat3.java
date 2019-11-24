package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * @author mac Given a string, find the length of the longest substring without
 *         repeating characters.
 * 
 *         Example 1:
 * 
 *         Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with
 *         the length of 3. Example 2:
 * 
 *         Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the
 *         length of 1. Example 3:
 * 
 *         Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the
 *         length of 3. Note that the answer must be a substring, "pwke" is a
 *         subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeat3 {
	// array
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int res = 0, left = 0;
		int[] hash = new int[128];
		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			hash[c[i]]++;
			while (hash[c[i]] > 1) {
				hash[c[left]]--;
				left++;
			}
			res = Math.max(res, i - left + 1);
		}
		return res;
	}

	// hashmap
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int res = 0, left = 0;
		char[] c = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < c.length; i++) {
			map.put(c[i], map.getOrDefault(c[i], 0) + 1);
			while (map.get(c[i]) > 1) {
				map.put(c[left], map.get(c[left]) - 1);
				left++;
			}
			res = Math.max(res, i - left + 1);
		}
		return res;
	}

	@Test
	public void test() {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring2(s));
	}
}
