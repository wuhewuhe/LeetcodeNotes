package String;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu Given two strings s and t , write a function to determine if t
 *         is an anagram of s.
 * 
 *         Example 1:
 * 
 *         Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * 
 *         Input: s = "rat", t = "car" Output: false
 */
public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		else {
			return changeFormat(s).equals(changeFormat(t));
		}
	}

	public String changeFormat(String str) {
		if (str.length() == 0)
			return "";
		else {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			StringBuilder sb = new StringBuilder();
			for (char cc : c)
				sb.append(cc);
			return sb.toString();
		}
	}

	public boolean isAnagram2(String s, String t) {
		int[] alphabet = new int[128];
		for (char c : s.toCharArray())
			alphabet[c]++;
		for (char c : t.toCharArray())
			alphabet[c]--;
		for (int i = 97; i<122;i++)
			if (alphabet[i] != 0)
				return false;
		return true;
	}

	@Test
	public void test() {
		System.out.println(isAnagram2("anagram", "nagaram"));
	}
}
