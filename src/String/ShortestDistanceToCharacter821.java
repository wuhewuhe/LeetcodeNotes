package String;

import java.util.Arrays;

/**
 * @author he.wu Given a string S and a character C, return an array of integers
 *         representing the shortest distance from the character C in the
 *         string.
 * 
 *         Example 1:
 * 
 *         Input: S = "loveleetcode", C = 'e' Output: [3, 2, 1, 0, 1, 0, 0, 1,
 *         2, 2, 1, 0]
 * 
 * 
 *         Note:
 * 
 *         S string length is in [1, 10000]. C is a single character, and
 *         guaranteed to be in string S. All letters in S and C are lowercase.
 */
public class ShortestDistanceToCharacter821 {
	// space o(1) time o(n*m)
	public static int[] shortestToChar(String str, char ch) {
		int[] ans = new int[str.length()];
		Arrays.fill(ans, Integer.MAX_VALUE);
		for (int i = 0; i < str.toCharArray().length; i++) {
			if (str.charAt(i) == ch)
				ans[i] = 0;
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == Integer.MAX_VALUE) {
				int left = 0, right = str.length() - 1, j = 1;
				while (i >= left || i <= right) {
					if (i + j <= right) {
						if (ans[i + j] == 0) {
							ans[i] = j;
							break;
						}
					}
					if (i - j >= left) {
						if (ans[i - j] == 0) {
							ans[i] = j;
							break;
						}
					}
					j++;
				}
			}
		}
		return ans;
	}

	public static int[] shortestToChar2(String str, char ch) {
		int n = str.length();
		int[] ans = new int[n];
		int prev = Integer.MIN_VALUE / 2;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == ch)
				prev = i;
			ans[i] = i - prev;
		}
		prev = Integer.MAX_VALUE / 2;
		for (int i = n - 1; i >= 0; i--) {
			if (str.charAt(i) == ch)
				prev = i;
			ans[i] = Math.min(prev - i, ans[i]);
		}
		return ans;
	}

	// binary search
	public int[] shortestToChar3(String S, char C) {
		int len = S.length();
		int[] ans = new int[len];
		char[] c = S.toCharArray();
		int lt, rt = -1, mid;
		for (int i = 0; i < len; i++) {
			if (c[i] == C) {
				ans[i] = 0;
				lt = rt;
				rt = i;
				if (lt == -1) {
					for (int j = 0; j < rt; j++)
						ans[j] = rt - j;
					continue;
				}
				mid = (lt + rt + 1) / 2;
				for (int j = lt + 1; j < mid; j++)
					ans[j] = j - lt;
				for (int j = mid; j < rt; j++)
					ans[j] = rt - j;
			}
		}
		int tail = len - 1;
		while (ans[tail] == 0 && c[tail] != C) {
			ans[tail] = tail - rt;
			tail--;
		}
		return ans;
	}

	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';
		System.out.println(shortestToChar2(S, C));
	}
}
