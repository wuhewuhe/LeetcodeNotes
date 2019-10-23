package TwoPointer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author he.wu Given an array A of integers, return the number of (contiguous,
 *         non-empty) subarrays that have a sum divisible by K.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: A = [4,5,0,-2,-3,1], K = 5 Output: 7 Explanation: There are 7
 *         subarrays with a sum divisible by K = 5: [4, 5, 0, -2, -3, 1], [5],
 *         [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 
 * 
 *         Note:
 * 
 *         1 <= A.length <= 30000 -10000 <= A[i] <= 10000 2 <= K <= 10000
 */
public class SubarraySumsDivisibleK974 {
	// time exceed
	public int subarraysDivByK(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				if ((sum[end] - sum[start]) % k == 0)
					count++;
			}
		}
		return count;
	}

	public int subarraysDivByK2(int[] nums, int k) {
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
		int[] count = new int[k];
		for (int x : sum)
			// if mod <0
			count[(x % k + k) % k]++;

		int ans = 0;
		for (int v : count)
			if (v > 1)
				ans += v * (v - 1) / 2;
		return ans;
	}

	public int subarraysDivByK3(int[] A, int K) {
		int sum = 0;
		int plus = K;
		while (plus < 10000) {
			plus += K;
		}

		Map<Integer, Integer> rmap = new HashMap<>();
		for (int i = 0; i < A.length; ++i) {
			sum += A[i] + plus;
			int r = sum % K;
			int count = rmap.getOrDefault(r, 0);
			rmap.put(r, count + 1);
		}
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : rmap.entrySet()) {
			int count = entry.getValue();
			if (entry.getKey() == 0) {
				total += (count + 1) * count / 2;
			} else {
				total += count * (count - 1) / 2;
			}
		}
		return total;
	}

	@Test
	public void test() {
		int[] nums = { 4, 5, 0, -2, -3, 1 };
		System.out.println(subarraysDivByK2(nums, 5));
	}

}
