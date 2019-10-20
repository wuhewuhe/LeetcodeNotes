package TwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac Given four lists A, B, C, D of integer values, compute how many
 *         tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is
 *         zero.
 * 
 *         To make problem a bit easier, all A, B, C, D have same length of N
 *         where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1
 *         and the result is guaranteed to be at most 231 - 1.
 * 
 *         Example:
 * 
 *         Input: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2]
 * 
 *         Output: 2
 * 
 *         Explanation: The two tuples are: 1. (0, 0, 0, 1) -> A[0] + B[0] +
 *         C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0 2. (1, 1, 0, 0) -> A[1] + B[1]
 *         + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII454 {
	// hashmap o(n^2)
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> sums = new HashMap<>();
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
//				if (sums.containsKey(sum)) {
//					sums.put(sum, sums.get(sum) + 1);
//				} else {
//					sums.put(sum, 1);
//				}
				sums.put(sum, sums.getOrDefault(sum, 0) + 1);
			}
		}
		for (int k = 0; k < A.length; k++) {
			for (int z = 0; z < C.length; z++) {
				int sum = -(C[k] + D[z]);
				if (sums.containsKey(sum)) {
					count += sums.get(sum);
				}
			}
		}
		return count;
	}

	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
		/* sorting, O(n^2*log(n)) time, O(n^2) space, no map */
		int nAB = A.length * B.length;
		int[] sumAB = new int[nAB];
		int i = 0;
		for (int a : A) {
			for (int b : B) {
				sumAB[i++] = a + b;
			}
		}
		Arrays.sort(sumAB);
		int nCD = C.length * D.length;
		int[] negSumCD = new int[nCD];
		i = 0;
		for (int c : C) {
			for (int d : D) {
				negSumCD[i++] = -(c + d);
			}
		}
		Arrays.sort(negSumCD);
		// if sumAB = negSumCD, then 4 sum = 0
		i = 0;
		int j = 0;
		int res = 0;
		while (i < nAB && j < nCD) {
			if (sumAB[i] < negSumCD[j])
				i++;
			else if (sumAB[i] > negSumCD[j])
				j++;
			else {
				// sumAB[i] == negSumCD[j]
				// need to count number of same consecutive values, and multiply them
				int countAB = 1, countCD = 1;
				while (++i < nAB && sumAB[i - 1] == sumAB[i])
					countAB += 1;
				while (++j < nCD && negSumCD[j - 1] == negSumCD[j])
					countCD += 1;
				res += countAB * countCD;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] A = { 1, 2 };
		int[] B = { -2, -1 };
		int[] C = { -1, 2 };
		int[] D = { 0, 2 };
		System.out.println(fourSumCount2(A, B, C, D));
	}

}
