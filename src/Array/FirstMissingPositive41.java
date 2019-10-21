package Array;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given an unsorted integer array, find the smallest missing
 *         positive integer.
 * 
 *         Example 1:
 * 
 *         Input: [1,2,0] Output: 3 Example 2:
 * 
 *         Input: [3,4,-1,1] Output: 2 Example 3:
 * 
 *         Input: [7,8,9,11,12] Output: 1
 */
public class FirstMissingPositive41 {
	// time o(n) space o(n)
	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 1;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(i + 1))
				return i + 1;
		}
		return nums.length + 1;
	}

	// constant space bucket sort
	public int firstMissingPositive2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
				int tem = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tem;
			}
		}
		return 0;
	}

	@Test
	public void test() {
		int[] nums = { 1 };
		System.out.println(firstMissingPositive(nums));
	}
}
