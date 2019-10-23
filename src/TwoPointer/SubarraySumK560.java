package TwoPointer;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author he.wu Given an array of integers and an integer k, you need to find
 *         the total number of continuous subarrays whose sum equals to k.
 * 
 *         Example 1: Input:nums = [1,1,1], k = 2 Output: 2 Note: The length of
 *         the array is in range [1, 20,000]. The range of numbers in the array
 *         is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumK560 {
	// brute force
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				int sum = 0;
				for (int i = start; i < end; i++)
					sum += nums[i];
				if (sum == k)
					count++;
			}
		}
		return count;
	}

	// Cumulative sum
	public int subarraySum2(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				if (sum[end] - sum[start] == k)
					count++;
			}
		}
		return count;
	}

	public int subarraySum3(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum += nums[end];
				if (sum == k)
					count++;
			}
		}
		return count;
	}

	// prefxisum[i,j] = prefixsum[j]-prefixsum[i-1]
	public int subarraySum4(int[] nums, int k) {
		int count = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	@Test
	public void test() {
		int[] nums = { 3, 4, 7, 2, -3, 1, 4, 2 };
		System.out.println(subarraySum4(nums, 7));
	}
}
