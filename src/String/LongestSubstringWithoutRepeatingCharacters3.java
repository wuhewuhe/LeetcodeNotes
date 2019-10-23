package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

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
public class LongestSubstringWithoutRepeatingCharacters3 {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<Character>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return ans;
	}

	// ascii time o(n)
	public int lengthOfLongestSubstring2(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128]; // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}

	public int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	@Test
	public void test() {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring3(s));
	}
}
