package TwoPointer;

import org.junit.Test;

/**
 * @author mac Given two binary strings, return their sum (also a binary
 *         string).
 * 
 *         The input strings are both non-empty and contains only characters 1
 *         or 0.
 * 
 *         Example 1:
 * 
 *         Input: a = "11", b = "1" Output: "100" Example 2:
 * 
 *         Input: a = "1010", b = "1011" Output: "10101"
 */
public class AddBinary69 {
	public String addBinary(String a, String b) {
		int n = Math.max(a.length(), b.length());
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = 1; i <= n; i++) {
			int ac = a.length() - i >= 0 ? a.charAt(a.length() - i) - '0' : 0;
			int bc = b.length() - i >= 0 ? b.charAt(b.length() - i) - '0' : 0;
			int sum = carry + ac + bc;
			if (sum > 1) {
				if (sum == 2)
					sb.append(0);
				if (sum == 3)
					sb.append(1);
				carry = 1;
			} else {
				sb.append(sum);
				carry = 0;
			}

		}
		return carry == 1 ? sb.append(1).reverse().toString() : sb.reverse().toString();
	}

	public String addBinary2(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

	public String addBinary3(String A, String B) {
		if ((A == null && B == null) || (A.length() == 0 && B.length() == 0))
			return "0";
		StringBuilder sb = new StringBuilder();
		char[] a = A != null ? A.toCharArray() : new char[0];
		char[] b = B != null ? B.toCharArray() : new char[0];

		int carry = 0, i = -1, j = -1;
		while (++i < a.length | ++j < b.length) {
			char valA = i >= a.length ? '0' : a[a.length - (i + 1)];
			char valB = j >= b.length ? '0' : b[b.length - (j + 1)];

			int sum = valA + valB + carry + -(2 * '0');
			if (sum > 1) {
				sb.append(sum - 2);
				carry = 1;
			} else {
				sb.append(sum);
				carry = 0;
			}
		}

		if (carry > 0)
			sb.append(1);
		return sb.reverse().toString();
	}

	// bit manipulation
	public String addBinary4(String a, String b) {
		if (a.length() < b.length())
			return addBinary(b, a);

		int i = 1, carry = 0, aLen = a.length(), bLen = b.length();
		char[] result = a.toCharArray();

		while (i <= aLen) {
			carry += (a.charAt(aLen - i) == '1') ? 1 : 0;
			carry += (i <= bLen && b.charAt(bLen - i) == '1') ? 1 : 0;
			result[aLen - i] = (char) ((carry & 1) + '0');
			carry = carry >> 1;
			i++;
		}

		return carry == 1 ? "1" + new String(result) : new String(result);
	}

	@Test
	public void test() {
		String a = "1010", b = "1011";
		System.out.println(addBinary(a, b));
	}
}
