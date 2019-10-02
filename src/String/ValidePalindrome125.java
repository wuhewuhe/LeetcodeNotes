package String;

/**
 * @author he.wu Given a string, determine if it is a palindrome, considering
 *         only alphanumeric characters and ignoring cases.
 * 
 *         Note: For the purpose of this problem, we define empty string as
 *         valid palindrome.
 * 
 *         Example 1:
 * 
 *         Input: "A man, a plan, a canal: Panama" Output: true Example 2:
 * 
 *         Input: "race a car" Output: false
 */
public class ValidePalindrome125 {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		char[] c = s.toCharArray();
		while (i < j) {
			if (c[i] >= 'A' && c[i] <= 'Z')
				c[i] += 'a' - 'A';
			if (c[j] >= 'A' && c[j] <= 'Z')
				c[j] += 'a' - 'A';
			if (!(c[i] >= 'a' && c[i] <= 'z' || c[i] >= '0' && c[i] <= '9')) {
				i++;
				continue;
			}
			if (!(c[j] >= 'a' && c[j] <= 'z' || c[j] >= '0' && c[j] <= '9')) {
				j--;
				continue;
			}
			if (c[i] != c[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
}
