package Math;

import org.junit.Test;

/**
 * @author he.wu Calculate the sum of two integers a and b, but you are not
 *         allowed to use the operator + and -.
 * 
 *         Example 1:
 * 
 *         Input: a = 1, b = 2 Output: 3 Example 2:
 * 
 *         Input: a = -2, b = 3 Output: 1
 */

/*
 * Bitwise operators are used to perform manipulation of individual bits of a
 * number. They can be used with any of the integral types (char, short, int,
 * etc).
 * 
 * Bitwise OR (|) – This operator is binary operator, denoted by ‘|’. It returns
 * bit by bit OR of input values, i.e, if either of the bits is 1, it gives 1,
 * else it gives 0.
 * 
 * Bitwise AND (&) – This operator is binary operator, denoted by ‘&’. It
 * returns bit by bit AND of input values, i.e, if both bits are 1, it gives 1,
 * else it gives 0.
 * 
 * Bitwise XOR (^) – This operator is binary operator, denoted by ‘^’. It
 * returns bit by bit XOR of input values, i.e, if corresponding bits are
 * different, it gives 1, else it gives 0.
 * 
 * This operator is unary operator, denoted by ‘~’. It returns the one’s
 * compliment representation of the input value, i.e, with all bits inversed,
 * means it makes every 0 to 1, and every 1 to 0.
 */

public class SumOfTwoInteger371 {
	public int getSum(int a, int b) {
		while (b != 0) {
			int c = a & b;
			a = a ^ b;
			b = c << 1;
		}
		return a;
	}

	@Test
	public void test() {
		System.out.println(getSum(11, 12));
	}
}
