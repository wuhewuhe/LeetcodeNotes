package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author mac Given a non-empty array of non-negative integers nums, the degree
 *         of this array is defined as the maximum frequency of any one of its
 *         elements.
 * 
 *         Your task is to find the smallest possible length of a (contiguous)
 *         subarray of nums, that has the same degree as nums.
 * 
 *         Example 1: Input: [1, 2, 2, 3, 1] Output: 2 Explanation: The input
 *         array has a degree of 2 because both elements 1 and 2 appear twice.
 *         Of the subarrays that have the same degree: [1, 2, 2, 3, 1], [1, 2,
 *         2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2] The shortest length
 *         is 2. So return 2. Example 2: Input: [1,2,2,3,1,4,2] Output: 6
 */
public class DegreeOfArray697 {
	public int findShortestSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int max = 1, res = Integer.MAX_VALUE;
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				List<Integer> temp = map.get(nums[i]);
				temp.add(i);
				map.put(nums[i], temp);
				count.put(nums[i], temp.size());
				if (temp.size() >= max) {
					max = temp.size();
				}
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(nums[i], temp);
				count.put(nums[i], 1);
			}
		}
		if (max == 1) {
			return 1;
		}
		for (int x : count.keySet()) {
			if (count.get(x) == max) {
				List<Integer> list = map.get(x);
				res = Math.min(res, list.get(list.size() - 1) - list.get(0) + 1);
			}
		}
		return res;
	}

	// left and right index
	public int findShortestSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!left.containsKey(nums[i])) {
				left.put(nums[i], i);
			}
			right.put(nums[i], i);
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
		}
		int degree = Collections.max(count.values());
		int ans = nums.length;
		for (int x : count.keySet()) {
			if (count.get(x) == degree) {
				ans = Math.min(ans, right.get(x) - left.get(x) + 1);
			}
		}
		return ans;
	}

	public int findShortestSubArray3(int[] A) {
		Map<Integer, Integer> count = new HashMap<>(), first = new HashMap<>();
		int res = 0, degree = 0;
		for (int i = 0; i < A.length; ++i) {
			first.putIfAbsent(A[i], i);
			count.put(A[i], count.getOrDefault(A[i], 0) + 1);
			if (count.get(A[i]) > degree) {
				degree = count.get(A[i]);
				res = i - first.get(A[i]) + 1;
			} else if (count.get(A[i]) == degree)
				res = Math.min(res, i - first.get(A[i]) + 1);
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 2, 3, 1 };
		System.out.println(findShortestSubArray(nums));
	}
}
