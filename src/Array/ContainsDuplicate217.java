package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given an array of integers, find if the array contains any
 *         duplicates.
 * 
 *         Your function should return true if any value appears at least twice
 *         in the array, and it should return false if every element is
 *         distinct.
 */

public class ContainsDuplicate217 {

	// time o(n) space o(1)
	public boolean ContainsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else
				map.put(nums[i], 1);
		}
		for (int i : map.values()) {
			if (i > 1)
				return true;
		}
		return false;
	}

	public boolean ContainsDuplicate3(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			else
				set.add(nums[i]);
		}
		return false;
	}

	// sort time o(nlogn) space 1
	public boolean ContainsDuplicate4(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

	// bubble sort time o(n^2) space o(1)
	public boolean ContainsDuplicate2(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}

	@Test
	public void test() {
	}
}
