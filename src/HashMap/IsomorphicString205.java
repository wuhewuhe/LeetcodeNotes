package HashMap;

import java.util.HashMap;

import org.junit.Test;

/**
 * @author mac Given two strings s and t, determine if they are isomorphic.
 * 
 *         Two strings are isomorphic if the characters in s can be replaced to
 *         get t.
 * 
 *         All occurrences of a character must be replaced with another
 *         character while preserving the order of characters. No two characters
 *         may map to the same character but a character may map to itself.
 * 
 *         Example 1:
 * 
 *         Input: s = "egg", t = "add" Output: true Example 2:
 * 
 *         Input: s = "foo", t = "bar" Output: false Example 3:
 * 
 *         Input: s = "paper", t = "title" Output: true Note: You may assume
 *         both s and t have the same length.
 */
public class IsomorphicString205 {
	// key value one to one
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s == null || t == null)
			return true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char si = s.charAt(i);
			char ti = t.charAt(i);
			if (map.containsKey(si)) {
				if (map.get(si) != ti)
					return false;
			} else {
				if (map.containsValue(ti))
					return false;
				map.put(si, ti);
			}
		}
		return true;
	}

	//hashtable 
	public boolean isIsomorphic2(String s1, String s2) {
		int[] m = new int[512];
		for (int i = 0; i < s1.length(); i++) {
			if (m[s1.charAt(i)] != m[s2.charAt(i) + 256])
				return false;
			m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
		}
		return true;
	}

	@Test
	public void test() {
		String s = "egg", t = "add";
		System.out.println(isIsomorphic2(s, t));
	}
}
