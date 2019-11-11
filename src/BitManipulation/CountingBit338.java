package BitManipulation;

import org.junit.Test;

/**
 * @author mac Given a non negative integer number num. For every numbers i in
 *         the range 0 ≤ i ≤ num calculate the number of 1's in their binary
 *         representation and return them as an array.
 * 
 *         Example 1:
 * 
 *         Input: 2 Output: [0,1,1] Example 2:
 * 
 *         Input: 5 Output: [0,1,1,2,1,2] Follow up:
 * 
 *         It is very easy to come up with a solution with run time
 *         O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly
 *         in a single pass? Space complexity should be O(n). Can you do it like
 *         a boss? Do it without using any builtin function like
 *         __builtin_popcount in c++ or in any other language.
 */

public class CountingBit338 {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		if (num == 0)
			return res;
		for (int i = 1; i < res.length; i++) {
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}

	public int[] countBits2(int num) {
		int[] res = new int[num + 1];
		if (num == 0)
			return res;
		for (int i = 1; i < res.length; i++) {
			res[i] = countOne(i);
		}
		return res;
	}

	private int countOne(int i) {
		int count = 0;
		while (i > 0) {
			if ((i & 1) == 1)
				count++;
			i >>= 1;
		}
		return count;
	}

	@Test
	public void test() {
		System.out.println(countBits2(5));
	}
}
