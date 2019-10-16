package TwoPointer;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Given two strings S and T, return if they are equal when both
 *         are typed into empty text editors. # means a backspace character.
 * 
 *         Example 1:
 * 
 *         Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T
 *         become "ac". Example 2:
 * 
 *         Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T
 *         become "". Example 3:
 * 
 *         Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T
 *         become "c". Example 4:
 * 
 *         Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c"
 *         while T becomes "b". Note:
 * 
 *         1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain
 *         lowercase letters and '#' characters.
 */
public class BackspaceStringCompare844 {
	public boolean backspaceCompare(String S, String T) {
		return helper(S).equals(helper(T));
	}

	private String build(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c != '#')
				stack.push(c);
			else {
				if (!stack.isEmpty())
					stack.pop();
			}
		}
		return String.valueOf(stack);
	}

	// stringbuilder
	private String helper(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c == '#') {
				if (sb.length() != 0)
					sb.deleteCharAt(sb.length() - 1);

			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	// space o(1) two pointer reverse
	public boolean backspaceCompare3(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		int countS = 0;
		int countT = 0;
		while (i >= 0 || j >= 0) {
			while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
				if (S.charAt(i) == '#')
					countS++;
				else
					countS--;
				i--;
			}
			char left = i < 0 ? '@' : S.charAt(i);
			while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
				if (T.charAt(j) == '#')
					countT++;
				else
					countT--;
				j--;
			}
			char right = j < 0 ? '@' : T.charAt(j);
			if (left != right)
				return false;
			i--;
			j--;
		}
		return true;
	}

	@Test
	public void test() {
		String S = "a##c", T = "#a#c";
		System.out.println(backspaceCompare3(S, T));
	}
}
