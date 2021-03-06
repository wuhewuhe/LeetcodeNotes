package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author he.wu
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int[] res = twoSum(nums, 9);
		System.out.println(res[0] + " " + res[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (record.containsKey(target - nums[i])) {
				return new int[] { i, record.get(target - nums[i]) };
			} else {
				record.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
