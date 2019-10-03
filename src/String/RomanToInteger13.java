package String;

import java.util.HashMap;

import org.junit.Test;

/**
 * @author he.wu Roman numerals are represented by seven different symbols: I,
 *         V, X, L, C, D and M.
 * 
 *         Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is
 *         written as II in Roman numeral, just two one's added together. Twelve
 *         is written as, XII, which is simply X + II. The number twenty seven
 *         is written as XXVII, which is XX + V + II.
 * 
 *         Roman numerals are usually written largest to smallest from left to
 *         right. However, the numeral for four is not IIII. Instead, the number
 *         four is written as IV. Because the one is before the five we subtract
 *         it making four. The same principle applies to the number nine, which
 *         is written as IX. There are six instances where subtraction is used:
 * 
 *         I can be placed before V (5) and X (10) to make 4 and 9. X can be
 *         placed before L (50) and C (100) to make 40 and 90. C can be placed
 *         before D (500) and M (1000) to make 400 and 900. Given a roman
 *         numeral, convert it to an integer. Input is guaranteed to be within
 *         the range from 1 to 3999.
 */
public class RomanToInteger13 {

	// hashmap o(n) 6ms beat 51.47
	public int romanToInt(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		char[] c = s.toCharArray();
		int ans = map.get(c[0]);
		for (int i = 1; i < c.length; i++) {
			if (c[i] == 'V' && c[i - 1] == 'I')
				ans += 3;
			else if (c[i] == 'X' && c[i - 1] == 'I')
				ans += 8;
			else if (c[i] == 'L' && c[i - 1] == 'X')
				ans += 30;
			else if (c[i] == 'C' && c[i - 1] == 'X')
				ans += 80;
			else if (c[i] == 'D' && c[i - 1] == 'C')
				ans += 300;
			else if (c[i] == 'M' && c[i - 1] == 'C')
				ans += 800;
			else
				ans += map.get(c[i]);
		}
		return ans;
	}

	// Switch
	// inverse the string and then calculate the sum from high to low
	public int romanToInt2(String input) {
		int sum = 0;
		int n = 0;

		for (int i = input.length() - 1; i >= 0; i--) {
			int m = 0;
			//m present each letter is which number
			switch (input.charAt(i)) {
			case 'I':
				m = 1;
				break;
			case 'V':
				m = 5;
				break;
			case 'X':
				m = 10;
				break;
			case 'L':
				m = 50;
				break;
			case 'C':
				m = 100;
				break;
			case 'D':
				m = 500;
				break;
			case 'M':
				m = 1000;
				break;
			}
			// n is the previous number that we scanned, m is the current number
			if (m < n)
				sum -= m;
			else
				sum += m;
			n = m;
		}

		return sum;
	}

	@Test
	public void test() {
		String s = "IV";
		System.out.println(romanToInt2(s));
	}
}
