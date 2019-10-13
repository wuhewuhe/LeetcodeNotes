package Array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given a non-negative index k where k ≤ 33, return the kth index
 *         row of the Pascal's triangle.
 * 
 *         Note that the row index starts from 0.
 * 
 *         In Pascal's triangle, each number is the sum of the two numbers
 *         directly above it.
 * 
 *         Example:
 * 
 *         Input: 3 Output: [1,3,3,1]
 */
public class PascalTriangleII119 {
	public List<Integer> getRow(int n) {
		List<Integer> tem = new ArrayList<Integer>();
		if(n<0 || n>33) return tem;
		int[][] arr = new int[34][34];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
			}
		}
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[n][i]==0)
				break;
			else
				tem.add(arr[n][i]);
		}
		return tem;
	}
	
	@Test
	public void test() {
		int n = 3;
		System.out.println(getRow(n));
	}
}
