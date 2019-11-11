package TwoPointer;

import org.junit.Test;

/**
 * @author mac Given two strings s1 and s2, write a function to return true if
 *         s2 contains the permutation of s1. In other words, one of the first
 *         string's permutations is the substring of the second string.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2
 *         contains one permutation of s1 ("ba"). Example 2:
 * 
 *         Input:s1= "ab" s2 = "eidboaoo" Output: False
 * 
 * 
 *         Note:
 * 
 *         The input strings only contain lower case letters. The length of both
 *         given strings is in range [1, 10,000].
 */
public class PermutationInString657 {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		int[] hash = new int[26];
		for (int i = 0; i < s1Arr.length; ++i) {
			hash[s1Arr[i] - 'a']++;
		}
		int l = 0, count = 0;
		for (int r = 0; r < s2Arr.length; ++r) {
			hash[s2Arr[r] - 'a']--;
			if (hash[s2Arr[r] - 'a'] >= 0) {
				count++;
			}
			if (r >= s1Arr.length) {
				hash[s2Arr[l] - 'a']++;
				if (hash[s2Arr[l] - 'a'] >= 1) {
					count--;
				}
				l++;
			}
			if (count == s1Arr.length) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void test() {
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(checkInclusion(s1, s2));
	}
}
