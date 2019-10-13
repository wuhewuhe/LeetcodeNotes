package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given a non-negative integer numRows, generate the first numRows
 *         of Pascal's triangle.
 *
 * 
 *         Example:
 * 
 *         Input: 5 Output: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 */
public class PascalTriangle118 {
	public List<List<Integer>> generate(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n < 0)
			return res;
		for (int i = 0; i < n; i++) {
			List<Integer> tem = new ArrayList<Integer>();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					tem.add(1);
				else {
					int a = res.get(i - 1).get(j);
					int b = res.get(i - 1).get(j - 1);
					tem.add(a + b);
				}
			}
			res.add(tem);
		}
		return res;
	}

	@Test
	public void test() {
		int n = 3;
		System.out.println(generate(n));
	}
}
