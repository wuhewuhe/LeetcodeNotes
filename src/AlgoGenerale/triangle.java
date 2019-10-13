package AlgoGenerale;

import java.util.Random;

public class triangle {

	// 打印二维数组
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n =5;
		int[][] arr = new int[n][n];
		int i = 0, j = 0;
		for (; i < n; i++) { // 行数
			arr[i][0] = 1;
			arr[i][i] = 1;
			for (j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		print(arr);
		System.out.println("  " + arr[4][2]);
	}
}
