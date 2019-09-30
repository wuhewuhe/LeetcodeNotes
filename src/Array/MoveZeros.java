package Array;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu Given an array nums, write a function to move all 0's to the
 *         end of it while maintaining the relative order of the non-zero
 *         elements.
 * 
 *         Example:
 * 
 *         Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 *         You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 */
public class MoveZeros {

	// can not desorder
	public static void moveZeroes(int[] nums) {
		if (nums.length == 0 || nums == null)
			throw new IllegalArgumentException("No solution");
		if (nums.length > 1) {
			int count = 0;
			for (int i : nums) {
				if (i == 0)
					count++;
			}
			if (count > 0) {
				Arrays.sort(nums);
				for (int i = 0; i < nums.length; i++) {
					if (i >= nums.length - count)
						nums[i] = 0;
					else
						nums[i] = nums[i + count];
				}
			}
		}
	}

	public static void moveZeroes2(int[] nums) {
		int zero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[zero++] = nums[i];
		}
		for (int i = zero; i < nums.length; i++)
			nums[i] = 0;
	}

	public static void moveZeroes3(int[] nums) {
		for (int zero = 0, i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums[zero++],nums[i]);
			}
		}
	}

	private static void swap(int i, int j) {
		// TODO Auto-generated method stub
		int tem = i+j;
		j = tem - j;
		i = tem - i;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes3(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
