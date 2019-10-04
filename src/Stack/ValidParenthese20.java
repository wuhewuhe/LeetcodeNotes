package Stack;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu
 *
 *         Given a string containing just the characters '(', ')', '{', '}', '['
 *         and ']', determine if the input string is valid.
 * 
 *         An input string is valid if:
 * 
 *         Open brackets must be closed by the same type of brackets. Open
 *         brackets must be closed in the correct order. Note that an empty
 *         string is also considered valid.
 * 
 *         Example 1:
 * 
 *         Input: "()" Output: true
 * 
 *         Example 2:
 * 
 *         Input: "()[]{}" Output: true
 * 
 *         Example 3:
 * 
 *         Input: "(]" Output: false
 * 
 *         Example 4:
 * 
 *         Input: "([)]" Output: false
 * 
 *         Example 5:
 * 
 *         Input: "{[]}" Output: true
 */
public class ValidParenthese20 {
	public boolean isValid(String s) {
		if (s.length() == 0 || s == null)
			return true;
		if (s.length() % 2 == 1)
			return false;
		Stack<Character> stack = new Stack<Character>();
		stack.add(s.charAt(0));
		char[] c = s.toCharArray();
		for (int i = 1; i < c.length; i++) {
			if (c[i] == '(' || c[i] == '[' || c[i] == '{')
				stack.add(c[i]);
			if (c[i] == ')' && stack.pop() != '(')
				return false;
			if (c[i] == ']' && stack.pop() != '[')
				return false;
			if (c[i] == '}' && stack.pop() != '{')
				return false;
		}
		return stack.size() == 0;
	}

	@Test
	public void test() {
		String s = "(()(";
		System.out.println(isValid(s));
	}
}
