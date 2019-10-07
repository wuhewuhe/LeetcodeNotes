package Recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given n pairs of parentheses, write a function to generate all
 *         combinations of well-formed parentheses.
 * 
 *         For example, given n = 3, a solution set is:
 * 
 *         [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class GenerateParenthese22 {
	public List<String> generateParenthesis(int n) {
        if(n <= 0 ) return null;
        List<String> list = new ArrayList<String>();
        parenthese("(", n-1,n,list);
        return list;
    }

	public void parenthese(String str, int left, int right, List<String> list) {
		if (left == 0 && right == 0)
			list.add(str);
		if (left > 0)
			parenthese(str + "(", left - 1, right, list);
		if (right > left)
			parenthese(str + ")", left, right - 1, list);
	}
	
	@Test
	public void test() {
		int n = 3;
		System.out.println(generateParenthesis(n));
	}
}
