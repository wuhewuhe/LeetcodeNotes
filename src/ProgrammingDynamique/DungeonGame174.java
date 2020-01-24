package ProgrammingDynamique;

import org.junit.Test;

/**
 * @author mac
 * 
 *         The demons had captured the princess (P) and imprisoned her in the
 *         bottom-right corner of a dungeon. The dungeon consists of M x N rooms
 *         laid out in a 2D grid. Our valiant knight (K) was initially
 *         positioned in the top-left room and must fight his way through the
 *         dungeon to rescue the princess.
 * 
 *         The knight has an initial health point represented by a positive
 *         integer. If at any point his health point drops to 0 or below, he
 *         dies immediately.
 * 
 *         Some of the rooms are guarded by demons, so the knight loses health
 *         (negative integers) upon entering these rooms; other rooms are either
 *         empty (0's) or contain magic orbs that increase the knight's health
 *         (positive integers).
 * 
 *         In order to reach the princess as quickly as possible, the knight
 *         decides to move only rightward or downward in each step.
 * 
 * 
 * 
 *         Write a function to determine the knight's minimum initial health so
 *         that he is able to rescue the princess.
 * 
 *         For example, given the dungeon below, the initial health of the
 *         knight must be at least 7 if he follows the optimal path RIGHT->
 *         RIGHT -> DOWN -> DOWN.
 * 
 *         -2 (K) -3 3 -5 -10 1 10 30 -5 (P)
 * 
 * 
 *         Note:
 * 
 *         The knight's health has no upper bound. Any room can contain threats
 *         or power-ups, even the first room the knight enters and the
 *         bottom-right room where the princess is imprisoned.
 */
public class DungeonGame174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] hp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++)
			hp[i][n] = Integer.MAX_VALUE;
		for (int i = 0; i < n + 1; i++)
			hp[m][i] = Integer.MAX_VALUE;
		hp[m][n - 1] = 1;
		hp[m - 1][n] = 1;
		for (int ii = m - 1; ii >= 0; ii--) {
			for (int jj = n - 1; jj >= 0; jj--) {
				hp[ii][jj] = Math.max(Math.min(hp[ii + 1][jj], hp[ii][jj + 1]) - dungeon[ii][jj], 1);
			}
		}
		return hp[0][0];
	}

	public int calculateMinimumHP2(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 0;
		int height = dungeon.length;
		int width = dungeon[0].length;
		int[][] hp = new int[height + 1][width + 1];
		for (int i = 0; i < height + 1; i++)
			hp[i][width] = Integer.MAX_VALUE;
		for (int i = 0; i < width + 1; i++)
			hp[height][i] = Integer.MAX_VALUE;
		hp[height][width - 1] = 1;
		hp[height - 1][width] = 1;
		for (int i = height - 1; i >= 0; i--) {
			for (int j = width - 1; j >= 0; j--) {
				int temp = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
				hp[i][j] = Math.max(temp, 1);
			}
		}
		return hp[0][0];
	}

	@Test
	public void test() {
		int[][] nums = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		System.out.println(calculateMinimumHP2(nums));
	}
}
