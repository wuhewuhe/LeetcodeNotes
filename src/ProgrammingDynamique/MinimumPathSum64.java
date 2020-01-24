package ProgrammingDynamique;

import org.junit.Test;

/**
 * @author mac Given a m x n grid filled with non-negative numbers, find a path
 *         from top left to bottom right which minimizes the sum of all numbers
 *         along its path.
 * 
 *         Note: You can only move either down or right at any point in time.
 * 
 *         Example:
 * 
 *         Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because
 *         the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum64 {
	public int minPathSum(int[][] grid) {
		int width = grid[0].length;
		int height = grid.length;
		int[][] ans = new int[height][width];
		ans[0][0] = grid[0][0];
		for (int i = 1; i < height; i++) {
			ans[i][0] = grid[i][0] + ans[i - 1][0];
		}
		for (int i = 1; i < width; i++) {
			ans[0][i] = grid[0][i] + ans[0][i - 1];
		}
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < width; j++) {
				ans[i][j] = Math.min(ans[i-1][j]+grid[i][j], ans[i][j-1]+grid[i][j]);
			}
		}
		return ans[height - 1][width - 1];
	}

	@Test
	public void test() {
		int[][] nums = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(nums));
	}
}
