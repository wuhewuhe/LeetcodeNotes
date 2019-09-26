package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given an array of integers and an integer k, find out whether
 *         there are two distinct indices i and j in the array such that nums[i]
 *         = nums[j] and the absolute difference between i and j is at most k.
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,2,3,1], k = 3 Output: true Example 2:
 * 
 *         Input: nums = [1,0,1,1], k = 1 Output: true Example 3:
 * 
 *         Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 */
public class ContainsDuplicate219 {

	// brutal loop 3 loop
	public boolean ContainsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0 || nums == null)
			return false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				for (int l = 1; l <= k; l++) {
					if (nums[i] == nums[j] && j + l < nums.length && nums[i] == nums[j + l])
						return true;
				}
			}
		}
		return false;
	}

	// hashmap solution time o(n) space o(k)
	public boolean ContainsNearbyDuplicate2(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
				return true;
			}

			map.put(nums[i], i);
		}
		return false;
	}

	// hashset solution, time o(n) space o(k)
	/*
	 * first loop aim at seeding first k value into set, while checking the
	 * acceptance criteria second loop iterate from k+1 to array.length, first
	 * remove i-(k+1) and check set exist the duplicate value finaly, add a new
	 * value to set, ensure the most apart is k
	 */
	public boolean ContainsNearbyDuplicate3(int[] nums, int k) {
		Set<Integer> storage = new HashSet<Integer>();

		for (int i = 0; i <= k && i < nums.length; i++) {
			if (storage.contains(nums[i])) {
				return true;
			}
			storage.add(nums[i]);
		}
		for (int i = k + 1; i < nums.length; i++) {
			storage.remove(nums[i - (k + 1)]);
			if (storage.contains(nums[i])) {
				return true;
			}
			storage.add(nums[i]);
		}
		return false;
	}

	public boolean ContainNearbyDuplicate4(int[] nums, int k) {
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hs.add(nums[i]) == false)
				return true;
			if (hs.size() == k + 1)
				hs.remove(nums[i - k]);
		}
		return false;
	}

	public boolean ContainsNearbyDuplicate5(int[] nums, int k) {
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);
		ArrayList<Integer> duplicate = new ArrayList<>();
		for (int i = 0; i < sorted.length - 1; i++) {
			if (sorted[i] == sorted[i + 1] && !duplicate.contains(sorted[i])) {
				duplicate.add(sorted[i]);
			}
		}
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = 0; i < nums.length; i++) {
//			if (map.containsKey(nums[i]))
//				map.put(nums[i], map.get(nums[i]) + 1);
//			else
//				map.put(nums[i], 1);
//		}
//		ArrayList<Integer> duplicate= new ArrayList<>();
//		for(int i : map.keySet()) {
//			if(map.get(i)>1) duplicate.add(i);
//		}
		for (int x : duplicate) {
			ArrayList<Integer> indexes = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == x) {
					indexes.add(i);
				}
			}
			for (int i = 0; i < indexes.size() - 1; i++) {
				if (indexes.get(i + 1) - indexes.get(i) <= k)
					return true;
			}
		}
		return false;
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		System.out.println(ContainsNearbyDuplicate5(nums, 2));
	}
}
