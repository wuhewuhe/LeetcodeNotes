package Graph;

/**
 * @author mac Given a non-empty 2D array grid of 0's and 1's, an island is a
 *         group of 1's (representing land) connected 4-directionally
 *         (horizontal or vertical.) You may assume all four edges of the grid
 *         are surrounded by water.
 * 
 *         Find the maximum area of an island in the given 2D array. (If there
 *         is no island, the maximum area is 0.)
 * 
 *         Example 1:
 * 
 *         [[0,0,1,0,0,0,0,1,0,0,0,0,0], [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *         [0,1,1,0,1,0,0,0,0,0,0,0,0], [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *         [0,1,0,0,1,1,0,0,1,1,1,0,0], [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *         [0,0,0,0,0,0,0,1,1,1,0,0,0], [0,0,0,0,0,0,0,1,1,0,0,0,0]] Given the
 *         above grid, return 6. Note the answer is not 11, because the island
 *         must be connected 4-directionally. Example 2:
 * 
 *         [[0,0,0,0,0,0,0,0]] Given the above grid, return 0. Note: The length
 *         of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaIsland695 {
	 final static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		public int maxAreaOfIsland(int[][] grid) {
			int maxArea = 0;
			final int xrows = grid.length;
			final int yrows = grid[0].length;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 1) {
						maxArea = Math.max(maxArea, dfs(grid, i, j, xrows, yrows));
					}
				}
			}

			return maxArea;
		}

		public int dfs(int[][] grid, int i, int j, int xrows, int yrows) {
			// corner case
			if (i < 0 || j < 0 || i >= xrows || j >= yrows || grid[i][j] == 0) {
				return 0;
			}
			// base case
			grid[i][j] = 0;
			int count = 1;
			for (int[] dir : dirs) {
				int x = dir[0] + i;
				int y = dir[1] + j;
				count += dfs(grid, x, y, xrows, yrows);
			}
			return count;
		}
}
