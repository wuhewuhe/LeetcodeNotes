package ProgrammingDynamique;

import org.junit.Test;

/**
 * @author mac A robot is located at the top-left corner of a m x n grid (marked
 *         'Start' in the diagram below).
 * 
 *         The robot can only move either down or right at any point in time.
 *         The robot is trying to reach the bottom-right corner of the grid
 *         (marked 'Finish' in the diagram below).
 * 
 *         How many possible unique paths are there?
 * 
 * 
 *         Note: m and n will be at most 100.
 * 
 *         Example 1:
 * 
 *         Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner,
 *         there are a total of 3 ways to reach the bottom-right corner: 1.
 *         Right -> Right -> Down 2. Right -> Down -> Right 3. Down -> Right ->
 *         Right Example 2:
 * 
 *         Input: m = 7, n = 3 Output: 28
 */
public class UniquePath62 {

	public int uniquePaths(int m, int n) {
		// corner case
		if (m == 0 || n == 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;
		// init state
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			res[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			res[0][i] = 1;
		}
		// loop the matrix
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// state change equation
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}

	public int uniquePaths2(int m, int n) {

		if (m == 0 && n == 0)
			return 0;

		return dfs(0, 0, m, n);

	}

	public int dfs(int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1)
			return 1;

		if (i >= m || j >= n)
			return 0;

		int sum = 0;

		sum += dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n);
		if (sum != 0)
			System.out.println(sum);
		return sum;
	}

	@Test
	public void test() {
		int m = 4, n = 4;
		System.out.println(uniquePaths2(m, n));
	}

}
