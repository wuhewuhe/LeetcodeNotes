package TwoPointer;

import java.math.BigInteger;

import org.junit.Test;

/**
 * @author he.wu Given two non-negative integers num1 and num2 represented as
 *         string, return the sum of num1 and num2.
 * 
 *         Note:
 * 
 *         The length of both num1 and num2 is < 5100. Both num1 and num2
 *         contains only digits 0-9. Both num1 and num2 does not contain any
 *         leading zero. You must not use any built-in BigInteger library or
 *         convert the inputs to integer directly.
 */
public class AddString443 {
	public String addStrings(String num1, String num2) {
		if (num1.length() == 0)
			return num2;
		if (num2.length() == 0)
			return num1;
		StringBuilder sb = new StringBuilder();
		int sum = 0, carry = 0, i = num1.length() - 1, j = num2.length() - 1;
		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0)
				sum += num1.charAt(i) - '0';
			if (j >= 0)
				sum += num2.charAt(j) - '0';
			sb.append(sum % 10);
			carry = sum / 10;
			i--;
			j--;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	public String addStrings2(String s, String t) {
		BigInteger i = new BigInteger(s);
		BigInteger j = new BigInteger(t);
		return String.valueOf(i.add(j));
	}

	@Test
	public void test() {
		String s1 = "99", s2 = "9";
		System.out.println(addStrings2(s1, s2));
	}
}
