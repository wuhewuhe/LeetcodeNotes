package String;


import org.junit.Test;

/**
 * @author he.wu Given a string which consists of lowercase or uppercase
 *         letters, find the length of the longest palindromes that can be built
 *         with those letters.
 * 
 *         This is case sensitive, for example "Aa" is not considered a
 *         palindrome here.
 * 
 *         Note: Assume the length of given string will not exceed 1,010.
 * 
 *         Example:
 * 
 *         Input: "abccccdd"
 * 
 *         Output: 7
 * 
 *         Explanation: One longest palindrome that can be built is "dccaccd",
 *         whose length is 7.
 */
public class LongestPalindrome409 {
	// greedy algo time o(n) space o(1)
	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int[] count = new int[128];
		for (char c : s.toCharArray())
			count[c]++;
		int ans = 0;
		for (int i : count) {
			ans += i / 2 * 2;
			// new string is an even number, we take a single char
			if (ans % 2 == 0 && i % 2 == 1)
				ans++;
		}
		return ans;
	}

	public int longestPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int[] nums = new int[128];
		for (char c : s.toCharArray())
			nums[c]++;
		int ans = 0;
		for (int i : nums) {
			ans += i / 2 * 2;
		}
		return ans == s.length() ? ans : ans + 1;
	}
	
	//bitwise operator 
	public int longestPalindrome3(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int[] nums = new int[128];
		for (char c : s.toCharArray())
			nums[c]++;
		int ans = 0;
		for (int i : nums) {
			ans += i / 2 * 2;
		}
		return ans == s.length() ? ans : ans + 1;
	}

	@Test
	public void test() {
		String s = "abcab";
		System.out.println(longestPalindrome(s));
	}
}
