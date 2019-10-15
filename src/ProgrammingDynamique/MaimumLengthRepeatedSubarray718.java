package ProgrammingDynamique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu
 *
 *         Given two integer arrays A and B, return the maximum length of an
 *         subarray that appears in both arrays.
 * 
 *         Example 1:
 * 
 *         Input: A: [1,2,3,2,1] B: [3,2,1,4,7] Output: 3 Explanation: The
 *         repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 *         Note:
 * 
 *         1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
 */
public class MaimumLengthRepeatedSubarray718 {


	// Bottom up programming dynamic
	public int findLength2(int[] A, int[] B) {
		if (A == null || B == null)
			return 0;
		int m = A.length;
		int n = B.length;
		int max = 0;
		// the length of longest common subarray end with A[i] and B[j]
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (A[i - 1] == B[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
						max = Math.max(max, dp[i][j]);
					}
				}
			}
		}
		return max;
	}

	@Test
	public void test() {

		int[] A = { 1, 2, 3, 2, 1 };
		int[] B = { 3, 2, 1, 4, 7 };
		System.out.println(findLength2(A, B));
	}
}
