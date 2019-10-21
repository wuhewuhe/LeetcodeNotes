package Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given an array containing n distinct numbers taken from 0, 1,
 *         2, ..., n, find the one that is missing from the array.
 * 
 *         Example 1:
 * 
 *         Input: [3,0,1] Output: 2 Example 2:
 * 
 *         Input: [9,6,4,2,3,5,7,0,1] Output: 8 Note: Your algorithm should run
 *         in linear runtime complexity. Could you implement it using only
 *         constant extra space complexity?
 */
public class MissingNumber268 {
	// loop
	public int missingNumber(int[] nums) {
		Arrays.sort(nums);
		// Ensure that n is at the last index
		if (nums[nums.length - 1] != nums.length) {
			return nums.length;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i != nums[i])
				return i;
		}
		// not missing any numbers
		return -1;
	}

	// hashset
	public int missingNumber2(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int num : nums)
			numSet.add(num);
		for (int i = 0; i < nums.length + 1; i++) {
			if (!numSet.contains(i))
				return i;
		}
		return -1;
	}

	// gauss formula
	public int missingNumber3(int[] nums) {
		int expectedSum = nums.length * (nums.length + 1) / 2;
		int actualSum = 0;
		for (int num : nums)
			actualSum += num;
		return expectedSum - actualSum;
	}

	// bit manipulation
	public int missingNumber4(int[] nums) {
		int miss = nums.length;
		for (int i = 0; i < nums.length; i++) {
			 miss ^= i ^ nums[i];
		}
		return miss;
	}

	@Test
	public void test() {
		int[] nums = { 2, 0, 3 };
		System.out.println(missingNumber4(nums));
		System.out.println(11^10);
	}
}
