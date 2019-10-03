package String;

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

	// no matter even or odd
	public boolean isPalindrome(CharSequence s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public boolean validPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < s.length(); i++) {
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			if (isPalindrome(sb))
				return true;
			sb.insert(i, c);
		}
		return isPalindrome(s);
	}

	public boolean isPalindromeRange(String s, int i, int j) {
		for (int k = i; k <= i + (j - i) / 2; k++) {
			if (s.charAt(k) != s.charAt(j - k + i))
				return false;
		}
		return true;
	}

	public boolean validPalindrome2(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				int j = s.length() - 1 - i;
				return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
			}
		}
		return true;
	}

	public boolean validPalindrome3(String source) {
		if (source == null || source.isEmpty()) {
			return true;
		}
		char[] res = source.toCharArray();
		int start = 0, end = res.length - 1;
		while (start < end) {
			if (res[start] != res[end]) {
				if (res[start + 1] == res[end]) {
					boolean isUntilLast = isTraverseUntilLast(start + 1, end, res);
					if (isUntilLast) {
						return true;
					}
				}
				if (res[start] == res[end - 1]) {
					return isTraverseUntilLast(start, end - 1, res);
				}
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private boolean isTraverseUntilLast(int start, int end, char[] source) {
		while (start < end && source[start] == source[end]) {
			start++;
			end--;
		}
		return start == end || Math.abs(start - end) == 1;
	}
}
