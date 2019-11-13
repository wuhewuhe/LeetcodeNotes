package TwoPointer;

import org.junit.Test;

/**
 * @author he.wu Given an array A of positive integers, call a (contiguous, not
 *         necessarily distinct) subarray of A good if the number of different
 *         integers in that subarray is exactly K.
 * 
 *         (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 *         Return the number of good subarrays of A.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: A = [1,2,1,2,3], K = 2 Output: 7 Explanation: Subarrays formed
 *         with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3],
 *         [1,2,1], [2,1,2], [1,2,1,2]. Example 2:
 * 
 *         Input: A = [1,2,1,3,4], K = 3 Output: 3 Explanation: Subarrays formed
 *         with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * 
 * 
 *         Note:
 * 
 *         1 <= A.length <= 20000 1 <= A[i] <= A.length 1 <= K <= A.length
 */
public class SubarrayWithKDifferentIntegers992 {
	public int subarraysWithKDistinct(int[] A, int K) {
		 if (A == null || A.length < K) {
		        return 0;
		    }
		    
		    int[] hash = new int[A.length + 1];
		    
		    int l = 0, results = 0, count = 0, result = 1;
		    for (int r = 0; r < A.length; ++r) {
		        hash[A[r]]++;
		        
		        if (hash[A[r]] == 1) {
		            count++;
		        }
		        
		        while (hash[A[l]] > 1 || count > K) {
		            if (count > K) {
		                result = 1;
		                count--;
		            } else {
		                result++;
		            }
		            hash[A[l]]--;
		            l++;
		        }
		        
		        if (count == K) {
		            results += result;
		        }
		    }
		    
		    return results;

	}

	@Test
	public void test() {
		int[] A = { 1, 2, 1, 2, 3 };
		int K = 2;
		System.out.println(subarraysWithKDistinct(A, K));
	}
}
