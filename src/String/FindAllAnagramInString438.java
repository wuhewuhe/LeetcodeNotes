package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author he.wu Given a string s and a non-empty string p, find all the start
 *         indices of p's anagrams in s.
 * 
 *         Strings consists of lowercase English letters only and the length of
 *         both strings s and p will not be larger than 20,100.
 * 
 *         The order of output does not matter.
 * 
 *         Example 1:
 * 
 *         Input: s: "cbaebabacd" p: "abc"
 * 
 *         Output: [0, 6]
 * 
 *         Explanation: The substring with start index = 0 is "cba", which is an
 *         anagram of "abc". The substring with start index = 6 is "bac", which
 *         is an anagram of "abc". Example 2:
 * 
 *         Input: s: "abab" p: "ab"
 * 
 *         Output: [0, 1, 2]
 * 
 *         Explanation: The substring with start index = 0 is "ab", which is an
 *         anagram of "ab". The substring with start index = 1 is "ba", which is
 *         an anagram of "ab". The substring with start index = 2 is "ab", which
 *         is an anagram of "ab".
 */
public class FindAllAnagramInString438 {

	// two pointer, sliding window
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		if (s.length() == 0 || p.length() == 0 || p.length() > s.length())
			return list;
		int[] hashP = new int[26], hashS = new int[26];
		for (char c : p.toCharArray()) {
			hashP[c - 'a']++;
		}
		int lenp = p.length(), lens = s.length(), count = 0;
		for (int i = 0; i < lens; i++) {
			hashS[s.charAt(i) - 'a']++;
			count++;
			if (count == lenp) {
				if (Arrays.equals(hashS, hashP))
					list.add(i + 1 - lenp);
				count--;
				hashS[s.charAt(i + 1 - lenp) - 'a']--;
			}
		}
		return list;
	}


	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}
}
