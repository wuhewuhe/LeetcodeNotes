package Math;

import org.junit.Test;

/**
 * @author he.wu Your task is to calculate ab mod 1337 where a is a positive
 *         integer and b is an extremely large positive integer given in the
 *         form of an array.
 * 
 *         Example 1:
 * 
 *         Input: a = 2, b = [3] Output: 8 Example 2:
 * 
 *         Input: a = 2, b = [1,0] Output: 1024
 */
public class SuperPow372 {

	/*
	 * ax+y=ax×ay; axy=(ax)y; (ab)%k=((a%k)(b%k))%k;
	 * 
	 */
	private static final int NUM = 1337;

	public int superPow(int a, int[] b) {
		int ans = 1;
		// not expecting to be a part of input
		if (b == null || b.length == 0)
			return 0;
		a = a % NUM;
		int len = b.length;
		for (int i = 0; i < len; i++) {
			ans = ((pow(ans, 10) * pow(a, b[i])) % NUM);
		}
		return ans;
	}

	private int pow(int a, int b) {
		if (b == 1)
			return a;
		if (b == 0)
			return 1;
		a = a % NUM;
		int res = a;
        for(int i = 1; i < b; i++)
            res = res * a % NUM;
        return res;
	}

	@Test
	public void test() {
		int[] a = { 1, 1 };
		System.out.println(superPow(2, a));
	}
}
