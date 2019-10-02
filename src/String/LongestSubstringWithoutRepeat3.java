package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

/**
 * @author he.wu Given a string, find the length of the longest substring
 *         without repeating characters.
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
	// brutal force
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		if (s.length() == 2)
			return s.charAt(0) != s.charAt(1) ? 2 : 1;
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (validString(s, i, j))
					ans = Math.max(ans, j - i);
			}
		}
		return ans;
	}

	private boolean validString(String s, int start, int end) {
		// TODO Auto-generated method stub
		HashSet<Character> set = new HashSet<Character>();
		for (int i = start; i < end; i++) {
			if (set.contains(s.charAt(i)))
				return false;
			set.add(s.charAt(i));
		}
		return true;
	}

	// two pointer
	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int fast = 0, slow = 0, ans = 0;
		HashSet<Character> set = new HashSet<Character>();
		while (fast < s.length() && slow < s.length()) {
			if (set.contains(s.charAt(fast))) {
				set.remove(s.charAt(slow));
				slow++;
			} else {
				set.add(s.charAt(fast));
				fast++;
			}
			ans = Math.max(ans, fast - slow);
		}
		return ans;
	}

	// hashmap
	public int lengthOfLongestSubstring3(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		if (s.length() == 2)
			return s.charAt(0) != s.charAt(1) ? 2 : 1;
		int ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int p = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				p = Math.max(map.get(s.charAt(i)), p);
			}
			map.put(s.charAt(i), i+1);
			ans = Math.max(ans, i - p + 1);
		}
		return ans;
	}
	
	 public int lengthOfLongestSubstring4(String s) {
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

	@Test
	public void test() {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring4(s));
	}

}
