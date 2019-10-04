package String;

import org.junit.Test;

/**
 * @author he.wu Given a non-empty string s, you may delete at most one
 *         character. Judge whether you can make it a palindrome.
 * 
 *         Example 1: Input: "aba" Output: True Example 2: Input: "abca" Output:
 *         True Explanation: You could delete the character 'c'. Note: The
 *         string will only contain lowercase characters a-z. The maximum length
 *         of the string is 50000.
 */

public class ValidePalindromeII680 {

	@Test
	public void test() {
		String s = "abc";
		System.out.println(validPalindrome2(s));
	}

	// no matter even or odd
	public boolean isPalindrome(CharSequence s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	// delete a char in string 1 is substring(0,i) + substring(i+1,s.length())
	// or change string to string builder
	public boolean validPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			// String result = s.substring(0, i) + s.substring(i + 1,s.length());
			sb.deleteCharAt(i);
			if (isPalindrome(sb))
				return true;
			sb.insert(i, s.charAt(i));
		}
		return isPalindrome(s);
	}

	public boolean validPalindrome2(String source) {
		if (source == null || source.isEmpty()) {
			return true;
		}
		char[] res = source.toCharArray();
		int start = 0, end = res.length - 1;
		while (start <= end) {
			if (res[start] != res[end])
				return isPalindrome(res, start, end - 1) || isPalindrome(res, start + 1, end);
			start++;
			end--;
		}
		return true;
	}

	private boolean isPalindrome(char[] res, int start, int end) {
		while(start<=end){
			if(res[start] != res[end]) return false;
			start++;
			end--;
		}
		return true;
	}

}
