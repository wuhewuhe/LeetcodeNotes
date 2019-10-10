package Math;

import org.junit.Test;

/**
 * @author he.wu 1201. Ugly Number III Medium
 * 
 *         82
 * 
 *         111
 * 
 *         Favorite
 * 
 *         Share Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive integers which are divisible by a or b or
 *         c.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: n = 3, a = 2, b = 3, c = 5 Output: 4 Explanation: The ugly
 *         numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4. Example 2:
 * 
 *         Input: n = 4, a = 2, b = 3, c = 4 Output: 6 Explanation: The ugly
 *         numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6. Example 3:
 * 
 *         Input: n = 5, a = 2, b = 11, c = 13 Output: 10 Explanation: The ugly
 *         numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10. Example 4:
 * 
 *         Input: n = 1000000000, a = 2, b = 217983653, c = 336916467 Output:
 *         1999999984
 */
public class UglyNumberIII1201 {
	public int nthUglyNumber(int n, int a, int b, int c) {
		int i =1;
		int ia = 0, ib = 0,ic =0;
		int[] ugly = new int[n+1];
		ugly[0] = 1;
		while(i<=n) {
			ugly[i] = Math.min(ugly[ia] * a, Math.min(ugly[ib] * b, ugly[ic] * c));
			if (ugly[i] == ugly[ia] * a) {
                ia++;
            }
            if (ugly[i] == ugly[ib] * b) {
                ib++;
            }
            if (ugly[i] == ugly[ic] * 5) {
                ic++;
            }
            i++;
		}
		return ugly[n];
	}
	
	//binary search
	
	@Test
	public void test() {
		System.out.println(nthUglyNumber(3,2,3,5));
	}
}
