package String;

/**
 * @author he.wu Determine whether an integer is a palindrome. An integer is a
 *         palindrome when it reads the same backward as forward.
 * 
 *         Example 1:
 * 
 *         Input: 121 Output: true Example 2:
 * 
 *         Input: -121 Output: false Explanation: From left to right, it reads
 *         -121. From right to left, it becomes 121-. Therefore it is not a
 *         palindrome. Example 3:
 * 
 *         Input: 10 Output: false Explanation: Reads 01 from right to left.
 *         Therefore it is not a palindrome.
 */
public class PalindromeNumber9 {
	public boolean isPalindrome(int x) {
		if (x < 0 || x > Integer.MAX_VALUE)
			return false;
		return reverse(x) == x ? true : false;
	}

	private int reverse(int x) {
		// TODO Auto-generated method stub
		int num = 0;
		while (x != 0) {
			num = num * 10 + x % 10;
			x /= 10;
		}
		return num;
	}

	//we can just compare a half of number
	public boolean isPalindrome2(int x) {
		if(x<0 || x%10==0 && x!=0) return false;
		if(x == 0) return true;
		int revert = 0;
		while(x > revert) {
			revert = revert * 10 + x % 10;
			x /= 10;
		}
		return x == revert || x == revert/10;
	}
}
