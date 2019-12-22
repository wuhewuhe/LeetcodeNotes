package Math;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Implement a basic calculator to evaluate a simple expression
 *         string.
 * 
 *         The expression string contains only non-negative integers, +, -, *, /
 *         operators and empty spaces . The integer division should truncate
 *         toward zero.
 * 
 *         Example 1:
 * 
 *         Input: "3+2*2" Output: 7 Example 2:
 * 
 *         Input: " 3/2 " Output: 1 Example 3:
 * 
 *         Input: " 3+5 / 2 " Output: 5 Note:
 * 
 *         You may assume that the given expression is always valid. Do not use
 *         the eval built-in library function.
 */

public class BasicCalculatorII227 {
	public int calculate(String s) {
		s = s.trim();
		if (s == null || s.length() == 0)
			return 0;
		char[] c = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(c[i])) {
				num = (num * 10) + c[i] - '0';
			}
			if (!Character.isDigit(c[i]) || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else {
					stack.push(stack.pop() / num);
				}
				num = 0;
				sign = c[i];
			}
		}
		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;
	}

	@Test
	public void test() {
		String s = "1+2*3/4";
		System.out.println(calculate(s));
	}
}
