package BitManipulation;

import org.junit.Test;

/**
 * @author mac Write a function that takes an unsigned integer and return the
 *         number of '1' bits it has (also known as the Hamming weight).
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: 00000000000000000000000000001011 Output: 3 Explanation: The
 *         input binary string 00000000000000000000000000001011 has a total of
 *         three '1' bits. Example 2:
 * 
 *         Input: 00000000000000000000000010000000 Output: 1 Explanation: The
 *         input binary string 00000000000000000000000010000000 has a total of
 *         one '1' bit. Example 3:
 * 
 *         Input: 11111111111111111111111111111101 Output: 31 Explanation: The
 *         input binary string 11111111111111111111111111111101 has a total of
 *         thirty one '1' bits.
 */
public class Number1bits191 {
	public int hammingWeight(int n) {
		int bits = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				bits++;
			}
			mask <<= 1;
		}
		return bits;
	}

	/*
	 *                n                    n-1               n&(n-1)
	 * 
	 * step1:   110101          110100          110100
	 * 
	 * step2:   110100          110011          110000
	 * 
	 * step3:   110000          101111          100000
	 * 
	 * step4:   100000          011111          000000
	 */
	public int hammingWeight2(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}

	@Test
	public void test() {
		int n = 00000000000000000000000000001011;
		System.out.println(hammingWeight(n));
	}
}
