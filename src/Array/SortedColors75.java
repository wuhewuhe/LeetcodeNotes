package Array;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac Given an array with n objects colored red, white or blue, sort
 *         them in-place so that objects of the same color are adjacent, with
 *         the colors in the order red, white and blue.
 * 
 *         Here, we will use the integers 0, 1, and 2 to represent the color
 *         red, white, and blue respectively.
 * 
 *         Note: You are not suppose to use the library's sort function for this
 *         problem.
 * 
 *         Example:
 * 
 *         Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Follow up:
 * 
 *         A rather straight forward solution is a two-pass algorithm using
 *         counting sort. First, iterate the array counting number of 0's, 1's,
 *         and 2's, then overwrite array with total number of 0's, then 1's and
 *         followed by 2's. Could you come up with a one-pass algorithm using
 *         only constant space?
 */
public class SortedColors75 {
	public void sortColors(int[] nums) {
		if (nums.length > 1) {
			Arrays.sort(nums);
		}
	}

	public void sortColors2(int[] A) {
		if (A == null || A.length < 2)
			return;
		int low = 0;
		int high = A.length - 1;
		for (int i = low; i <= high;) {
			if (A[i] == 0) {
				// swap A[i] and A[low] and i,low both ++
				int temp = A[i];
				A[i] = A[low];
				A[low] = temp;
				i++;
				low++;
			} else if (A[i] == 2) {
				// swap A[i] and A[high] and high--;
				int temp = A[i];
				A[i] = A[high];
				A[high] = temp;
				high--;
			} else {
				i++;
			}
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 0 };
		sortColors2(nums);
		
	}

}
