package TwoPointer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac Given a string, find the length of the longest substring T that
 *         contains at most 2 distinct characters. For example, Given s =
 *         â€œecebaâ€�, T is "ece" which its length is 3.
 * 
 */
public class LongestSubstringTwoDistinctNumbers159 {

	// hashtable
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		int l = 0, count = 0, res = 0;
		char[] sArr = s.toCharArray();
		int[] hash = new int[256];
		for (int r = 0; r < s.length(); r++) {
			hash[s.charAt(r)]++;
			if (hash[sArr[r]] == 1) {
				count++;
			}
			while (count > 2) {
				hash[sArr[l]]--;

				if (hash[sArr[l]] == 0) {
					count--;
				}

				l++;
			}

			res = Math.max(res, r - l + 1);
		}
		return res;
	}

	// HashMap
	public int lengthOfLongestSubstringTwoDistinct2(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		int l = 0, count = 0, res = 0;
		char[] c = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < c.length; i++) {
			if (map.containsKey(c[i])) {
				map.put(c[i], map.get(c[i]) + 1);
			} else {
				map.put(c[i], 1);
				count++;
			}

			while (count > 2) {
				char tem = c[l++];
				map.put(tem, map.get(tem) - 1);
				if (map.get(tem) == 0)
					count--;
			}

			res = Math.max(i - l + 1, res);
		}
		return res;
	}

	@Test
	public void test() {
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct2(s));
	}
}
