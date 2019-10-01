package String;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author he.wu 345. Reverse Vowels of a String Easy
 * 
 *         445
 * 
 *         833
 * 
 *         Favorite
 * 
 *         Share Write a function that takes a string as input and reverse only
 *         the vowels of a string.
 * 
 *         Example 1:
 * 
 *         Input: "hello" Output: "holle" Example 2:
 * 
 *         Input: "leetcode" Output: "leotcede" Note: The vowels does not
 *         include the letter "y".
 */
public class EvaluateReversePolishNotation150 {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return null;

		Matcher m = Pattern.compile("(?:(a)|(e)|(i)|(o)|(u)|.)+", Pattern.CASE_INSENSITIVE).matcher(s);
		if (!m.matches())
			return s;
		else {
			HashSet<Character> c2 = new HashSet<Character>();
			String vowel = "aeiouAEIOU";
			for (char c : vowel.toCharArray())
				c2.add(c);
			char[] c1 = s.toCharArray();
			int k = c1.length - 1;
			for (int i = 0; i < c1.length / 2; i++) {

				if (c2.contains(c1[i])) {
					while (k > i) {
						if (c2.contains(c1[k]))
							break;
						k--;
					}
					char tem = c1[i];
					c1[i] = c1[k];
					c1[k] = tem;
					k--;
				}
			}
			StringBuilder sb = new StringBuilder();
			for (char c : c1)
				sb.append(c);
			return sb.toString();
		}

	}

	public String ReverseVowels(String s) {
		if (s == null || s.length() == 0)
			return s;
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {// two pointer encounter, it means that we scan the whole array
			// find the first vowel from first element
			while (start < end && !vowels.contains(chars[start] + "")) {
				start++;
			}
			// find the last vowel from last element
			while (start < end && !vowels.contains(chars[end] + "")) {
				end--;
			}
			// swap two elements
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			// update index, after one action
			start++;
			end--;
		}
		return new String(chars);
	}

	public String ReverseVowels2(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;
		//two pointer first and last 
		int i = 0;
		int j = s.length() - 1;
		char ch[] = s.toCharArray();
		//map, aeiou AEIOU initial 
		boolean[] map = new boolean[256];
		map['a'] = true;
		map['e'] = true;
		map['i'] = true;
		map['o'] = true;
		map['u'] = true;
		map['A'] = true;
		map['E'] = true;
		map['O'] = true;
		map['I'] = true;
		map['U'] = true;
		while (i < j) {
			if (map[ch[i]] && map[ch[j]]) {
				swap(ch, i, j);
				i++;
				j--;
			} else if (map[ch[j]]) {
				i++;
			} else if (map[ch[i]]) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		return new String(ch);
	}

	private void swap(char[] s, int i, int j) {
		char ch = s[i];
		s[i] = s[j];
		s[j] = ch;
	}

	@Test
	public void test() {
		String s1 = "leetcode";
		System.out.println(ReverseVowels2(s1));
	}
}
