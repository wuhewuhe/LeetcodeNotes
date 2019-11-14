package TwoPointer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

/**
 * @author he.wu Given a string S, return the number of substrings of length K
 *         with no repeated characters.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: S = "havefunonleetcode", K = 5 Output: 6 Explanation: There
 *         are 6 substrings they are :
 *         'havef','avefu','vefun','efuno','etcod','tcode'. Example 2:
 * 
 *         Input: S = "home", K = 5 Output: 0 Explanation: Notice K can be
 *         larger than the length of S. In this case is not possible to find any
 *         substring.
 * 
 * 
 *         Note:
 * 
 *         1 <= S.length <= 10^4 All characters of S are lowercase English
 *         letters. 1 <= K <= 10^4
 */
public class FindKSubstringsWithNoRepeatedCharacters1100 {
	public int numKLenSubstrNoRepeats(String s, int k) {
		if (s == null || s.length() == 0 || s.length() < k)
			return 0;
		char[] cs = s.toCharArray();
		int[] hash = new int[26];
		for (int i = 0; i < k; i++) {
			hash[cs[i] - 'a']++;
		}
		int res = 0;
		if (check(hash))
			res++;
		for (int i = k; i < cs.length; i++) {
			hash[cs[i] - 'a']++;
			hash[cs[i - k]-'a']--;
			if (check(hash))
				res++;
		}
		return res;
	}

	private boolean check(int[] hash) {
		for (int i : hash) {
			if (i > 1)
				return false;
		}
		return true;
	}

	@Test
	public void test() {
		String S = "havefunonleetcode";
		int K = 5;
		System.out.println(numKLenSubstrNoRepeats(S, K));
	}
}
