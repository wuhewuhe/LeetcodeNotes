package Math;

/**
 * @author he.wu Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5.
 * 
 *         Example:
 * 
 *         Input: n = 10 Output: 12 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
 *         is the sequence of the first 10 ugly numbers. Note:
 * 
 *         1 is typically treated as an ugly number. n does not exceed 1690.
 */
public class UglyNumberII264 {
	// time and space o(n)
	public int nthUglyNumber(int n) {
		if (n < 0)
			return -1;
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;
		for (int i = 1; i < n; i++) {
			ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
			if (ugly[i] == ugly[i2] * 2) {
                i2++;
            }
            if (ugly[i] == ugly[i3] * 3) {
                i3++;
            }
            if (ugly[i] == ugly[i5] * 5) {
                i5++;
            }
		}
		return ugly[n-1];
	}
	
}
