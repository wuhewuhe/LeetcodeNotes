package String;

import org.junit.Test;

/**
 * @author he.wu Given a string, determine if it is a palindrome, considering
 *         only alphanumeric characters and ignoring cases.
 * 
 *         Note: For the purpose of this problem, we define empty string as
 *         valid palindrome.
 * 
 *         Example 1:
 * 
 *         Input: "A man, a plan, a canal: Panama" Output: true
 * 
 *         Example 2:
 * 
 *         Input: "race a car" Output: false
 */
public class ValidePalindrome125 {
	// 3 ms beat 95.97
	public boolean isPalindrome(String s) {
		int p1 = 0, p2 = s.length() - 1;
		char[] c = s.toCharArray();
		// ascii 48 0 57 9, 65 a, 90 z, 97 A, 122 Z
		while (p1 <= p2) {
			// this character is not letter or digits, push one
			if ((c[p1] < 48 || c[p1] > 57) && (c[p1] < 65 || c[p1] > 90) && (c[p1] < 97 || c[p1] > 122)) {
				p1++;
				continue;
			}
			// this character is not letter or digits, push one
			if ((c[p2] < 48 || c[p2] > 57) && (c[p2] < 65 || c[p2] > 90) && (c[p2] < 97 || c[p2] > 122)) {
				p2--;
				continue;
			}
//			// boolean true = 0,false = 1
//			if ((c[p1] < 48 || c[p1] > 57) ^ (c[p2] < 48 || c[p2] > 57))
//				return false;
//			// compare a - z A -Z, ignore case, capital letter minus lower case is 32
//			if (c[p1] != c[p2] && Math.abs(c[p1] - c[p2]) != 32)
//				return false;
			if (Character.toLowerCase(c[p1]) != Character.toLowerCase(c[p2]))
				return false;
			p1++;
			p2--;
		}
		return true;
	}

	@Test
	public void test() {
		String s = "0=";
		System.out.println(isPalindrome3(s));
		System.out.println(true ^ true);
	}

	// time nlogn space o 1
	public boolean isPalindrome2(String s) {
		// TODO Auto-generated method stub
		if (s.length() < 2)
			return true;
		s = s.toLowerCase().replace(" ", "");
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)))
				i++;
			else if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)))
				j--;
			else if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

	public boolean isPalindrome3(String s) {
		int p1 = 0, p2 = s.length() - 1;
		char[] c = s.toCharArray();
		// ascii 48 0 57 9, 65 a, 90 z, 97 A, 122 Z
		while (p1 <= p2) {
			// this character is not letter or digits, push one
			if ((c[p1] < 48 || c[p1] > 57) && (c[p1] < 65 || c[p1] > 90) && (c[p1] < 97 || c[p1] > 122)) {
				p1++;
				continue;
			}
			// this character is not letter or digits, push one
			if ((c[p2] < 48 || c[p2] > 57) && (c[p2] < 65 || c[p2] > 90) && (c[p2] < 97 || c[p2] > 122)) {
				p2--;
				continue;
			}
			// boolean true = 1,false = 0, true ^ true = false like 1 ^ 1 = 0
			// if two letter is number, we will ignore and compare in the next step
			// if two letter one is number another is a or = return false  
			if ((c[p1] < 48 || c[p1] > 57) ^ (c[p2] < 48 || c[p2] > 57))
				return false;
			// compare a - z A -Z, ignore case, capital letter minus lower case is 32
			if (c[p1] != c[p2] && Math.abs(c[p1] - c[p2]) != 32)
				return false;
			p1++;
			p2--;
		}
		return true;
	}

}
