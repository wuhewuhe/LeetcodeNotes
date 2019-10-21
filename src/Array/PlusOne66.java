package Array;

import org.junit.Test;

/**
 * @author he.wu Given a non-empty array of digits representing a non-negative
 *         integer, plus one to the integer.
 * 
 *         The digits are stored such that the most significant digit is at the
 *         head of the list, and each element in the array contain a single
 *         digit.
 * 
 *         You may assume the integer does not contain any leading zero, except
 *         the number 0 itself.
 * 
 *         Example 1:
 * 
 *         Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the
 *         integer 123. Example 2:
 * 
 *         Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents
 *         the integer 4321.
 */
public class PlusOne66 {
	public int[] plusOne(int[] digits) {
		if (digits.length == 0 || digits == null)
			throw new IllegalArgumentException("No two sum solution");
		if (digits.length == 1) {
			digits[0] += 1;
			return digits;
		}
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;

		return newNumber;
	}

	public int[] PlusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			throw new IllegalArgumentException("No solution");
		if (digits.length == 1) {
			digits[0] += 1;
			return digits;
		}
		for (int i = digits.length - 1; i >= 0; i--) {
			if(digits[i]<9)
			{
				digits[i]+=1;
				return digits;
			}
			else digits[i] = 0;
		}
		int[] number = new int[digits.length+1];
		number[0] = 1;
		return number;
	}

	@Test
	public void test() {
		int[] ar = { 9, 9 };
		System.out.println(PlusOne(ar));

	}

}
