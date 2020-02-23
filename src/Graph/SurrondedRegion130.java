package Graph;

import org.junit.Test;

/**
 * @author mac Given a 2D board containing 'X' and 'O' (the letter O), capture
 *         all regions surrounded by 'X'.
 * 
 *         A region is captured by flipping all 'O's into 'X's in that
 *         surrounded region.
 * 
 *         Example:
 * 
 *         X X X X X O O X X X O X X O X X After running your function, the
 *         board should be:
 * 
 *         X X X X X X X X X X X X X O X X Explanation:
 * 
 *         Surrounded regions shouldn’t be on the border, which means that any
 *         'O' on the border of the board are not flipped to 'X'. Any 'O' that
 *         is not on the border and it is not connected to an 'O' on the border
 *         will be flipped to 'X'. Two cells are connected if they are adjacent
 *         cells connected horizontally or vertically.
 */
public class SurrondedRegion130 {
	@Test
	public void test() {
		char[][] chars = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(chars);
	}

	final static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public void solve(char[][] board) {
		// corner case
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		// variable
		int m = board.length;
		int n = board[0].length;

		// Start from first and last column, turn 'O' to '*'.
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				dfs(board, i, 0, m, n);
			if (board[i][n - 1] == 'O')
				dfs(board, i, n - 1, m, n);
		}
		// Start from first and last row, turn '0' to '*'
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O')
				dfs(board, 0, j, m, n);
			if (board[m - 1][j] == 'O')
				dfs(board, m - 1, j, m, n);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	public void dfs(char[][] grid, int x, int y, int m, int n) {
		if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
			return;
		}
		if (grid[x][y] == 'O') {
			grid[x][y] = '*';
		} else {
			return;
		}
		for (int[] dir : dirs) {
			int i = dir[0] + x;
			int j = dir[1] + y;
			dfs(grid, i, j, m, n);
		}

	}
}
