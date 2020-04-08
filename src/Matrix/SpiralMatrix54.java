package Matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mac Given a matrix of m x n elements (m rows, n columns), return all
 *         elements of the matrix in spiral order.
 * 
 *         Example 1:
 * 
 *         Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output:
 *         [1,2,3,6,9,8,7,4,5] Example 2:
 * 
 *         Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output:
 *         [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 *         clockwise
 */
public class SpiralMatrix54 {
	public static List<Integer> spiralOrder(int[][] matrix) {
		// corner case
		List<Integer> ls = new LinkedList<>();
		if (matrix == null || matrix.length == 0) {
			return ls;
		}

		int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

		// first loop
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				ls.add(matrix[top][i]);
			}
			for (int i = top; i < bottom; i++) {
				ls.add(matrix[i][right]);
			}
			for (int i = right; i > left; i--) {
				ls.add(matrix[bottom][i]);
			}
			for (int i = bottom; i > top; i--) {
				ls.add(matrix[i][left]);
			}
			top++;
			bottom--;
			left++;
			right--;
		}

		// second loop
		if (left == right) {
			for (int i = top; i <= bottom; i++) {
				ls.add(matrix[i][left]);
			}
		} else if (top == bottom) {
			for (int i = left; i <= right; i++) {
				ls.add(matrix[top][i]);
			}
		}
		return ls;
	}

	public static void main(String[] args) {
		int[][] i = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.deepToString(i));
		List<Integer> l = spiralOrder(i);
		System.out.println(l);
	}
}
