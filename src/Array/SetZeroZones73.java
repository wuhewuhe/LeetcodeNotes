package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mac Given a m x n matrix, if an element is 0, set its entire row and
 *         column to 0. Do it in-place.
 * 
 *         Example 1:
 * 
 *         Input: [ [1,1,1], [1,0,1], [1,1,1] ] Output: [ [1,0,1], [0,0,0],
 *         [1,0,1] ] Example 2:
 * 
 *         Input: [ [0,1,2,0], [3,4,5,2], [1,3,1,5] ] Output: [ [0,0,0,0],
 *         [0,4,5,0], [0,3,1,0] ] Follow up:
 * 
 *         A straight forward solution using O(mn) space is probably a bad idea.
 *         A simple improvement uses O(m + n) space, but still not the best
 *         solution. Could you devise a constant space solution?
 */
public class SetZeroZones73 {
	public void setZeroes(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();

		// Essentially, we mark the rows and columns that are to be made zero
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		// Iterate over the array once again and using the rows and cols sets, update
		// the elements.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void setZeroes2(int[][] matrix) {
		int MODIFIED = -1000000;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (matrix[r][c] == 0) {
					// We modify the corresponding rows and column elements in place.
					// Note, we only change the non zeroes to MODIFIED
					for (int k = 0; k < C; k++) {
						if (matrix[r][k] != 0) {
							matrix[r][k] = MODIFIED;
						}
					}
					for (int k = 0; k < R; k++) {
						if (matrix[k][c] != 0) {
							matrix[k][c] = MODIFIED;
						}
					}
				}
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// Make a second pass and change all MODIFIED elements to 0 """
				if (matrix[r][c] == MODIFIED) {
					matrix[r][c] = 0;
				}
			}
		}
	}
}
