package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author mac Given a 2d grid map of '1's (land) and '0's (water), count the
 *         number of islands. An island is surrounded by water and is formed by
 *         connecting adjacent lands horizontally or vertically. You may assume
 *         all four edges of the grid are all surrounded by water.
 * 
 *         Example 1:
 * 
 *         Input: 11110 11010 11000 00000
 * 
 *         Output: 1 Example 2:
 * 
 *         Input: 11000 11000 00100 00011
 * 
 *         Output: 3
 */
public class NumberOfISland200 {

	@Test
	public void test() {
		char[][] lands = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(lands));
	}

	// DFS
	final static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public int numIslands(char[][] grid) {
		// corner case
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int count = 0;
		final int xrows = grid.length;
		final int yrows = grid[0].length;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j, xrows, yrows);
					count++;
				}
			}
		return count;
	}

	private void dfs(char[][] grid, int i, int j, int xrows, int yrows) {
		// corner case
		if (i < 0 || j < 0 || i >= xrows || j >= yrows || grid[i][j] == '0') {
			return;
		}
		// base case
		grid[i][j] = '0';
		for (int[] dir : dirs) {
			int x = dir[0] + i;
			int y = dir[1] + j;
			dfs(grid, x, y, xrows, yrows);
		}
	}

	// BFS
	public int numIslands2(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length, n = grid[0].length;

		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					bfs(grid, queue, visited);
					count++;
				}
			}
		}

		return count;
	}

	private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];

				if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '0')
					continue;

				visited[x][y] = true;
				queue.offer(new int[] { x, y });
			}
		}
	}

	public int numIslands3(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfsFill(grid, i, j);
					count++;
				}
			}
		return count;
	}

	private void bfsFill(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		int n = grid.length;
		int m = grid[0].length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int code = x * m + y;
		queue.offer(code);
		while (!queue.isEmpty()) {
			code = queue.poll();
			int i = code / m;
			int j = code % m;
			if (i > 0 && grid[i - 1][j] == '1') // search upward and mark adjacent '1's as '0'.
			{
				queue.offer((i - 1) * m + j);
				grid[i - 1][j] = '0';
			}
			if (i < n - 1 && grid[i + 1][j] == '1') // down
			{
				queue.offer((i + 1) * m + j);
				grid[i + 1][j] = '0';
			}
			if (j > 0 && grid[i][j - 1] == '1') // left
			{
				queue.offer(i * m + j - 1);
				grid[i][j - 1] = '0';
			}
			if (j < m - 1 && grid[i][j + 1] == '1') // right
			{
				queue.offer(i * m + j + 1);
				grid[i][j + 1] = '0';
			}
		}
	}
}
