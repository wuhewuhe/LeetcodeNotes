package Array;

import java.util.HashMap;
import java.util.Map;

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
