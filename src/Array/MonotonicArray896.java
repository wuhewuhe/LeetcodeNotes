package Array;

import org.junit.Test;

/**
 * @author he.wu An array is monotonic if it is either monotone increasing or
 *         monotone decreasing.
 * 
 *         An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An
 *         array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * 
 *         Return true if and only if the given array A is monotonic.
 */
public class MonotonicArray896 {

	// two pass, si increasing si descending
	public boolean isMonotonic(int[] nums) {
		if (nums.length == 0 || nums == null)
			return false;
		boolean up = true;
		boolean down = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) {
				down = false;
				break;
			}
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				up = false;
				break;
			}
		}
		return up || down;
	}

	// one pass
	public boolean isMonotonic2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return false;
		boolean up = true;
		boolean down = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1])
				down = false;
			if (nums[i] > nums[i + 1])
				up = false;
		}
		return up || down;
	}

	// if else
	public boolean isMonotonic3(int[] nums) {
		if (nums.length < 2)
			return true;
		else {
			if (nums[0] <= nums[nums.length - 1]) {
				for (int i = 0; i < nums.length - 1; i++) {
					if (nums[i] > nums[i + 1])
						return false;
				}
				return true;
			} else {
				for (int i = 0; i < nums.length - 1; i++) {
					if (nums[i] < nums[i + 1])
						return false;
				}
				return true;
			}
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 1, 2 };
		System.out.println(isMonotonic3(nums));
	}
}
