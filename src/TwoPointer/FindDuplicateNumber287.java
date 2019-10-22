package TwoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given an array nums containing n + 1 integers where each
 *         integer is between 1 and n (inclusive), prove that at least one
 *         duplicate number must exist. Assume that there is only one duplicate
 *         number, find the duplicate one.
 * 
 *         Example 1:
 * 
 *         Input: [1,3,4,2,2] Output: 2 Example 2:
 * 
 *         Input: [3,1,3,4,2] Output: 3 Note:
 * 
 *         You must not modify the array (assume the array is read only). You
 *         must use only constant, O(1) extra space. Your runtime complexity
 *         should be less than O(n2). There is only one duplicate number in the
 *         array, but it could be repeated more than once.
 */
public class FindDuplicateNumber287 {
	// sort algo
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return nums[i];
			}
		}

		return -1;
	}

	// hashset
	public int findDuplicate2(int[] nums) {
		if (nums.length < 2)
			return -1;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i))
				return i;
			set.add(i);
		}
		return -1;
	}

	// floyd tortoise and hare cycle detection
	public int findDuplicate3(int[] nums) {
		// Find the intersection point of the two runners.
		int tortoise = nums[0];
		int hare = nums[nums[0]];
		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		}
		hare = 0;
		while (hare != tortoise) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}

		return tortoise;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate3(nums));
	}
}
