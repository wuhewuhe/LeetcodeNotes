package HashMap;

import java.util.HashMap;

import org.junit.Test;

/**
 * @author mac Given a pattern and a string str, find if str follows the same
 *         pattern.
 * 
 *         Here follow means a full match, such that there is a bijection
 *         between a letter in pattern and a non-empty word in str.
 * 
 *         Example 1:
 * 
 *         Input: pattern = "abba", str = "dog cat cat dog" Output: true Example
 *         2:
 * 
 *         Input:pattern = "abba", str = "dog cat cat fish" Output: false
 *         Example 3:
 * 
 *         Input: pattern = "aaaa", str = "dog cat cat dog" Output: false
 *         Example 4:
 * 
 *         Input: pattern = "abba", str = "dog dog dog dog" Output: false Notes:
 *         You may assume pattern contains only lowercase letters, and str
 *         contains lowercase letters that may be separated by a single space.
 */
public class wordPattern290 {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null)
			return false;
		String[] strs = str.split(" ");
		if (strs.length != pattern.length())
			return false;
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(strs[i]))
					return false;
			} else {
				if (map.containsValue(strs[i]))
					return false;
				map.put(pattern.charAt(i), strs[i]);
			}
		}
		return true;
	}

	@Test
	public void test() {
		String pattern = "abba", str = "dog dog dog dog";
		System.out.println(wordPattern(pattern, str));
	}
}
