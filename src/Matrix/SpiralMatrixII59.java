package Matrix;

import java.util.Arrays;

/**
 * @author mac Given a positive integer n, generate a square matrix filled with
 *         elements from 1 to n2 in spiral order.
 * 
 *         Example:
 * 
 *         Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralMatrixII59 {
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int top = 0, bottom = n - 1, left = 0, right = n - 1, count = 1;
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				res[top][i] = count++;
			}
			for (int i = top; i < bottom; i++) {
				res[i][right] = count++;
			}
			for (int i = right; i > left; i--) {
				res[bottom][i] = count++;
			}
			for (int i = bottom; i > top; i--) {
				res[i][left] = count++;
			}
			top++;
			bottom--;
			left++;
			right--;
		}
		// if (left == right && bottom == top && left == bottom) {
		if (n % 2 != 0) {
			res[top][left] = count;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(Arrays.deepToString(generateMatrix(n)));
	}
}
