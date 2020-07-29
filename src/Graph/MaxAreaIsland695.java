package Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

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
	Map<Integer, Integer> map = new HashMap<>();

	// complete the matrix
	public int[][] complete(int[][] grid) {
		int max = 0, weight = 0;
		for (int[] arr : grid) {
			max = Math.max(max, arr.length);
			weight++;
		}
		int[][] matrix = new int[weight][max];
		for (int i = 0; i < weight; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				matrix[i][j] = grid[i][j];
			}
		}
		return matrix;
	}

	public void arrayOfLand(int[][] grid) {
		// int maxArea = 0;
		final int xrows = grid.length;
		final int yrows = grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					// maxArea = Math.max(maxArea, dfs(grid, i, j, xrows, yrows));
					int temp = dfs(grid, i, j, xrows, yrows);
					map.put(temp, map.getOrDefault(temp, 0) + 1);
				}
			}
		}
		// return map;
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

	public int[] query(int[] arr) {
		// corner case
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] ans = new int[arr.length];
		// loop map
		for (int i = 0; i < ans.length; i++) {
			ans[i] = map.getOrDefault(arr[i], 0);
		}
		return ans;
	}

	@Test
	public void test() {
		int[][] graph = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		
		int[][] grid = complete(graph);
		arrayOfLand(grid);
		map.forEach((key, value) -> System.out.println(key + ":" + value));
		int[] tt = { 1, 2, 4, 5 };
		System.out.println(Arrays.toString(query(tt)));
	}
}
