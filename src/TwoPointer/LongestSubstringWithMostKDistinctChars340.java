package TwoPointer;

import org.junit.Test;

/**
 * @author he.wu Given a string, find the length of the longest substring T that
 *         contains at most k distinct characters.
 * 
 *         For example, Given s = “eceba” and k = 2,
 * 
 *         T is "ece" which its length is 3.
 * 
 */
public class LongestSubstringWithMostKDistinctChars340 {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0)
			return 0;
		if (k >= s.length())
			return s.length();
		int[] hash = new int[26];
		int l = 0, count = 0, res = 0;
		for (int i = 0; i < s.length(); i++) {
			hash[s.charAt(i) - 'a']++;
			if (hash[s.charAt(i) - 'a'] == 1)
				count++;
			while (count > k) {
				if (--hash[s.charAt(l++) - 'a'] == 0)
					count--;
			}
			res = Math.max(i - l + 1, res);
		}
		return res;
	}

	@Test
	public void test() {
		String s = "eceba";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
	}
}
